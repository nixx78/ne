package lv.nixx.ne.receiver;

import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.nixx.ne.rest.model.InMessage;

@Component
@RabbitListener(queues="sms-channel-queue")
public class SmsChannelListener {
	
	private Logger log = LoggerFactory.getLogger(SmsChannelListener.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RabbitHandler
	public void receiveMessage(InMessage message) {
		log.debug("SmsChannelListiner: Log message [{}] ", message);
		
		rabbitTemplate.convertAndSend("channel-response-queue", message);
	}

}
