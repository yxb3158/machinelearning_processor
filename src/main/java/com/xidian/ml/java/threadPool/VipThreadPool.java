package com.xidian.ml.java.threadPool;

import org.springframework.stereotype.Service;

/**
 * Created by yxb on 16/12/22.
 */
@Service
public class VipThreadPool extends ThreadPools {

    @Override
    protected Integer getMccThreadCount() {
        return 3;
    }

    @Override
    protected Integer getMccQueueSize() {
        return 10;
    }
}



