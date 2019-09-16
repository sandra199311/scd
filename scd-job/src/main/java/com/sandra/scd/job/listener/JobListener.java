package com.sandra.scd.job.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * @author: lenovo
 * @Description: 任务监听器，统计每次任务执行的时间
 * @Date: 2019/6/26 10:43
 **/
public class JobListener implements ElasticJobListener {

//  private long beginTime = 0;

    @Override
    public void beforeJobExecuted(final ShardingContexts shardingContexts) {
//    beginTime = System.currentTimeMillis();

//    logger.info("===>{} JOB BEGIN TIME: {} <===", shardingContexts.getJobName(),
//        TimeUtil.mill2Time(beginTime));
    }

    @Override
    public void afterJobExecuted(final ShardingContexts shardingContexts) {
//    long endTime = System.currentTimeMillis();
//    logger.info("===>{} JOB END TIME: {},TOTAL CAST: {} <===", shardingContexts.getJobName(),
//        TimeUtil.mill2Time(endTime), endTime - beginTime);
    }

}
