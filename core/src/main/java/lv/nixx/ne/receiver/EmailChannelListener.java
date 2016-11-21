package lv.nixx.ne.receiver;

import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.nixx.ne.rest.model.InMessage;

@Component
//@RabbitListener(queues="email-channel-queue", containerFactory="emailChannelContainerFactory")
@RabbitListener(queues="email-channel-queue")
public class EmailChannelListener {
	
	private Logger log = LoggerFactory.getLogger(EmailChannelListener.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RabbitHandler
	public void receiveMessage(InMessage message) {
		log.debug("EmailChannelListiner: Log message [{}] ", message);
		synchronized (this) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		rabbitTemplate.convertAndSend("channel-response-queue", message);
		
	}

}
