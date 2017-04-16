package com.xidian.ml.trident.spout;

import org.apache.storm.trident.spout.ITridentSpout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public class DefaultCoordinator implements ITridentSpout.BatchCoordinator<Long>, Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCoordinator.class);
    private static final long serialVersionUID = 1L;

    @Override
    public boolean isReady(long txid) {
        return true;
    }

    @Override
    public void close() {
    }

    @Override
    public Long initializeTransaction(long txid, Long prevMetadata, Long currMetadata) {
        LOGGER.info("Initializing Transaction [" + txid + "]");
        return null;
    }

    @Override
    public void success(long txid) {
        LOGGER.info("Successful Transaction [" + txid + "]");
    }
}