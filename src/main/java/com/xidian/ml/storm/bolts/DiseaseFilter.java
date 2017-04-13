package com.xidian.ml.storm.bolts;

import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.tuple.TridentTuple;

/**
 * Created by yxb on 2017/3/24.
 */
public class DiseaseFilter extends BaseFilter {
    public DiseaseFilter() {
    }

    @Override
    public boolean isKeep(TridentTuple tridentTuple) {
        return false;
    }
}
