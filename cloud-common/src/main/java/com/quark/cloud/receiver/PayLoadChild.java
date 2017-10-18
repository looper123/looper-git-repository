package com.quark.cloud.receiver;

/**
 * Created by ZhenpengLu on 2017/10/18.
 * 用于发送通道消息内容分配
 */
public class PayLoadChild {

    private String partitionKey;

    private String partitionData;

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public String getPartitionData() {
        return partitionData;
    }

    public void setPartitionData(String partitionData) {
        this.partitionData = partitionData;
    }
}
