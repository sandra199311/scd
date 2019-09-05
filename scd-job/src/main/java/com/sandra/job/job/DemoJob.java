package com.sandra.job.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author: sandra
 * @Description: Demo Job
 * @Date: 2019/6/26 09:52
 **/
public class DemoJob implements SimpleJob {

  @Override
  public void execute(ShardingContext shardingContext) {

    System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
        Thread.currentThread().getId(), shardingContext.getShardingTotalCount(),
        shardingContext.getShardingItem()));

    //每个分片分配任务
    switch (shardingContext.getShardingItem()) {
      case 0:
        // do something by sharding item 0
        break;
      case 1:
        // do something by sharding item 1
        break;
      case 2:
        // do something by sharding item 2
        break;
      // case n: ...
    }

  }
}
