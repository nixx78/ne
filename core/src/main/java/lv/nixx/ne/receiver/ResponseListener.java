package lv.nixx.ne.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.nixx.ne.model.Status;
import lv.nixx.ne.persistence.MessageDAO;
import lv.nixx.ne.rest.model.InMessage;

@Component
@RabbitListener(queues="channel-response-queue")
public class ResponseListener {
	
	@Autowired
	private MessageDAO dao;
	
	@RabbitHandler
	public void receiveMessage(InMessage message) {
		dao.setMessageState(message.getCorrelationId(), Status.DELIVERED);
	}

}
