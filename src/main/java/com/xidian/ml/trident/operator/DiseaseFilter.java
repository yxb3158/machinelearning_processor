package com.xidian.ml.trident.operator;

import com.xidian.ml.trident.model.DiagnosisEvent;
import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiseaseFilter extends BaseFilter {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(DiseaseFilter.class);

    @Override
    public boolean isKeep(TridentTuple tuple) {
        DiagnosisEvent diagnosis = (DiagnosisEvent) tuple.getValue(0);
        Integer code = Integer.parseInt(diagnosis.diagnosisCode);
        if (code.intValue() <= 322) {
            LOGGER.info("Emitting disease [" + diagnosis.diagnosisCode + "]");
            return true;
        } else {
            LOGGER.info("Filtering disease [" + diagnosis.diagnosisCode + "]");
            return false;
        }
    }
}