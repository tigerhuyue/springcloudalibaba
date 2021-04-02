package com.winsion.net.taskservice.message.output;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;




@RocketMQTransactionListener(txProducerGroup = "myTxProducerGroup", corePoolSize = 5, maximumPoolSize = 10)
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
	@Override
	public RocketMQLocalTransactionState executeLocalTransaction(Message msg,
                                                                 Object arg) {
		Object num = msg.getHeaders().get("taskservice");

		System.out.println(
				"executer: " + new String((byte[]) msg.getPayload()) + " commit");
		return RocketMQLocalTransactionState.COMMIT;
	}

	@Override
	public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
		System.out.println("check: " + new String((byte[]) msg.getPayload()));
		return RocketMQLocalTransactionState.COMMIT;
	}
}