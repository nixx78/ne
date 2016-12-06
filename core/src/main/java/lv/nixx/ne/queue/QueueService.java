package lv.nixx.ne.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.nixx.ne.rest.model.InMessage;

@Service
public class QueueService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendMessageToInboundQueue(InMessage message) {
		rabbitTemplate.convertAndSend("inbound-message-queue", message);
	}

	public void sendMessageToOutboundQueue(String routingKey, InMessage message) {
		rabbitTemplate.convertAndSend("outgoing-message-exchange", routingKey, message);		
	}

	public void sendResponseMessage(InMessage message) {
		rabbitTemplate.convertAndSend("channel-response-queue", message);		
	}
	
}
