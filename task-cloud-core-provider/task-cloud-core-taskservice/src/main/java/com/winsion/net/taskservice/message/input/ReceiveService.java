package com.winsion.net.taskservice.message.input;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:fangjian0423@gmail.com">Jim</a>
 */
@EnableBinding({ MessageSink.class})
public class ReceiveService {

    @StreamListener("receiveCTCChannel")
    public void receiveCTCMsg(String receiveMsg) {
        System.out.println("receiveTaskMsgChannel receive: " + receiveMsg);
    }


    @StreamListener("receiveTaskClinetChannel")
    public void receiveTaskClinetMsg(String transactionMsg) {
        System.out.println("input4 receive transaction msg: " + transactionMsg);
    }

}
