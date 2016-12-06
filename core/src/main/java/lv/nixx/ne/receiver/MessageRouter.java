package lv.nixx.ne.receiver;

import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.nixx.ne.model.Status;
import lv.nixx.ne.persistence.MessageDAO;
import lv.nixx.ne.queue.QueueService;
import lv.nixx.ne.rest.model.InMessage;

@Component
@RabbitListener(queues="inbound-message-queue")
public class MessageRouter {
	
	private Logger log = LoggerFactory.getLogger(MessageRouter.class);
	
	@Autowired
	private MessageDAO dao;
	
	@Autowired
	private QueueService queueService;
	
	@RabbitHandler
	public void receiveMessage(InMessage message) {
		log.info("Log message [{}] ", message);
		
		String routingKey = message.getChannel();
		dao.setMessageState(message.getCorrelationId(), Status.ROUTED);
		
		queueService.sendMessageToOutboundQueue(routingKey, message);
	}

}
