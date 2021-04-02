package com.winsion.net.taskservice.message.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

public interface MessageSink {

    /**
     * @CTC数据接收通道
     */
    @Input("receiveCTCChannel")
    SubscribableChannel receiveCTCChannel();

    /**
     * @return 客户端消息接收通道
     */
    @Input("receiveTaskClinetChannel")
    SubscribableChannel receiveTaskClinetChannel();

}
