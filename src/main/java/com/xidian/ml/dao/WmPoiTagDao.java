package com.xidian.ml.dao;

import com.xidian.ml.domain.WmPoiYexiaoStat;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by yxb on 16/5/17.
 */
@Component
//@DataSource("dataSource")
public interface WmPoiTagDao {

    public static final String all_field = "wm_poi_id,yexiao_b,yexiao_a,ts";

    public static final String TABLE_NAME = "waimai_snack_poi_list";

    @Select(" select " + all_field + " from " + TABLE_NAME + " where wm_poi_id = #{wm_poi_id}")
    public WmPoiYexiaoStat getByWmPoiId(@Param("wm_poi_id") long wm_poi_id);

    @Select(" select " + all_field + " from " + TABLE_NAME + " where wm_poi_id = #{wm_poi_id} and #{TagType} = #{TagType}")
    public Object getByWmPoiIdAndTagType(@Param("wm_poi_id") long wm_poi_id, @Param("TagType") String TagType);
}