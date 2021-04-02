package com.winsion.net.taskservice.message.output;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    /**
     * 一般消息通道
     *
     * @return
     */
    @Output("outTaskMsgChannel")
    MessageChannel outTaskMsgChannel();

    /**
     * 事务消息通道
     *
     * @return
     */
    @Output("outTaskTransactionaMsgChannel")
    MessageChannel outTaskTransactionaMsgChannel();

}
