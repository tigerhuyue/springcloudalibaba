package com.winsion.net.taskservice.message.output;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class SenderService {


    @Autowired
    private MessageSource source;



    public void send(String msg) throws Exception {
        source.outTaskMsgChannel().send(MessageBuilder.withPayload(msg).build());
    }

    public <T> void sendWithTags(T msg, String tag)  {
        Message message = MessageBuilder.createMessage(msg,
                new MessageHeaders(Stream.of(tag).collect(Collectors
                        .toMap(str -> MessageConst.PROPERTY_TAGS, String::toString))));
        source.outTaskMsgChannel().send(message);
    }

    public <T> void sendObject(T msg, String tag) throws Exception {
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        source.outTaskMsgChannel().send(message);
    }

    public <T> void sendTransactionalMsg(T msg, int num) throws Exception {
        MessageBuilder builder = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        builder.setHeader("taskservice", String.valueOf(num));
        builder.setHeader(RocketMQHeaders.TAGS, "binder");
        Message message = builder.build();
        source.outTaskTransactionaMsgChannel().send(message);
    }
}
