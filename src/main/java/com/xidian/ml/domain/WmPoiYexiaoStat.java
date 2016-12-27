package com.xidian.ml.domain;

/**
 * Created by yxb on 16/12/23.
 */
public class WmPoiYexiaoStat {
    private long wm_poi_id;
    private int yexiao_b;
    private int yexiao_a;
    private long ts;

    public long getWm_poi_id() {
        return wm_poi_id;
    }

    public void setWm_poi_id(long wm_poi_id) {
        this.wm_poi_id = wm_poi_id;
    }

    public int getYexiao_b() {
        return yexiao_b;
    }

    public void setYexiao_b(int yexiao_b) {
        this.yexiao_b = yexiao_b;
    }

    public int getYexiao_a() {
        return yexiao_a;
    }

    public void setYexiao_a(int yexiao_a) {
        this.yexiao_a = yexiao_a;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "WmPoiYexiaoStat{" +
                "wm_poi_id=" + wm_poi_id +
                ", yexiao_b=" + yexiao_b +
                ", yexiao_a=" + yexiao_a +
                ", ts=" + ts +
                '}';
    }
}
