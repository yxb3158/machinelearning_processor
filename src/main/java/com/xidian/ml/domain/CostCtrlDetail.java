package com.xidian.ml.domain;

public class CostCtrlDetail {
    private Long id;//主键id
    private Long ctrlId;//成本控制id
    private String ctrlTime;//成本控制时段(201804)
    private Integer areaId;//区域id.0:全国,area_type=1则city_id,area_type=2则aor_id
    private Double costEstimate;//区域预算成本
    private Double costActual;//实际花费
    private String costActualDetail;//实际花费详情
    private Integer ctime;//保存时间
    private Integer utime;//更新时间


    public CostCtrlDetail() {

    }

    public CostCtrlDetail(Long ctrlId, Integer areaId, String ctrlTime) {
        this.ctrlId = ctrlId;
        this.areaId = areaId;
        this.ctrlTime = ctrlTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCtrlId() {
        return this.ctrlId;
    }

    public void setCtrlId(Long ctrlId) {
        this.ctrlId = ctrlId;
    }

    public String getCtrlTime() {
        return this.ctrlTime;
    }

    public void setCtrlTime(String ctrlTime) {
        this.ctrlTime = ctrlTime;
    }

    public Integer getAreaId() {
        return this.areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Double getCostEstimate() {
        return this.costEstimate;
    }

    public void setCostEstimate(Double costEstimate) {
        this.costEstimate = costEstimate;
    }

    public Double getCostActual() {
        return this.costActual;
    }

    public void setCostActual(Double costActual) {
        this.costActual = costActual;
    }

    public String getCostActualDetail() {
        return this.costActualDetail;
    }

    public void setCostActualDetail(String costActualDetail) {
        this.costActualDetail = costActualDetail;
    }

    public Integer getCtime() {
        return this.ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public Integer getUtime() {
        return this.utime;
    }

    public void setUtime(Integer utime) {
        this.utime = utime;
    }
}