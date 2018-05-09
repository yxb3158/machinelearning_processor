package com.xidian.ml.dao;

import com.xidian.ml.domain.CostCtrlDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author xds
 * @createdate 2018/04/18 下午5:17
 */
@Component
public interface CostCtrlDetailDao {
    String INSERT_FIELD = "ctrl_id,ctrl_time,area_id,cost_estimate,cost_actual,cost_actual_detail";
    String ALL_FIELD = "id," + INSERT_FIELD + ",utime,ctime";
    String INSERT_VALUE = "#{ctrlId},#{ctrlTime},#{areaId},#{costEstimate},#{costActual},#{costActualDetail}";
    String TABLE = "cost_ctrl_detail";

    @Update("update " + TABLE + " set cost_actual = cost_actual + #{costActual},utime = unix_timestamp() " + " where ctrl_id=#{ctrlId} and area_id=#{areaId} and ctrl_time=#{ctrlTime} and #{costActual} + cost_actual < cost_estimate")
    public Integer updateCostActualByUniqueKey(CostCtrlDetail costCtrlDetail);

    @Insert("insert into " + TABLE + " (" + INSERT_FIELD + ",utime,ctime) values (" + INSERT_VALUE + ",unix_timestamp(),unix_timestamp()) ")
    @Options(useGeneratedKeys = true)
    Integer insert(CostCtrlDetail costCtrlDetail);

    @Select({"/*master*/ select " + ALL_FIELD + " from " + TABLE + " where ctrl_id = #{ctrlId} and ctrl_time = #{ctrlTime} and area_id = #{areaId}"})
    public CostCtrlDetail getByUniqueKey(CostCtrlDetail uniqueQuery);
}
