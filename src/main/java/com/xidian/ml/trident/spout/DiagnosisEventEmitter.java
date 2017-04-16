package com.xidian.ml.trident.spout;


import com.xidian.ml.trident.model.DiagnosisEvent;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.spout.ITridentSpout;
import org.apache.storm.trident.topology.TransactionAttempt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class DiagnosisEventEmitter implements ITridentSpout.Emitter<Long>, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisEventEmitter.class);

    private static final long serialVersionUID = 1L;
    AtomicInteger successfulTransactions = new AtomicInteger(0);

    @Override
    public void emitBatch(TransactionAttempt tx, Long coordinatorMeta, TridentCollector collector) {
        for (int i = 0; i < 10000; i++) {
            List<Object> events = new ArrayList<Object>();
            double lat = new Double(-30 + (int) (Math.random() * 75));
            double lng = new Double(-120 + (int) (Math.random() * 70));
            long time = System.currentTimeMillis();

            String diag = new Integer(320 + (int) (Math.random() * 7)).toString();
            String diag1 = new Integer(320 + (int) (Math.random() * 10)).toString();
            DiagnosisEvent event = new DiagnosisEvent(lat, lng, time, diag);
            DiagnosisEvent event1 = new DiagnosisEvent(lat, lng, time, diag1);
            events.add(event);
//            events.add(event1);
//            logger.info("-----------events:{}", JSON.toJSONString(events));
            collector.emit(events);
        }
    }

    @Override
    public void success(TransactionAttempt tx) {
        successfulTransactions.incrementAndGet();
    }

    @Override
    public void close() {
    }

}
