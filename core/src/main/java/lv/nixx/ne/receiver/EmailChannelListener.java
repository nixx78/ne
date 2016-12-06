package lv.nixx.ne.receiver;

import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.nixx.ne.queue.QueueService;
import lv.nixx.ne.rest.model.InMessage;

@Component
@RabbitListener(queues="email-channel-queue", containerFactory="emailChannelContainerFactory")
@RabbitListener(queues="email-channel-queue")
public class EmailChannelListener {
	
	private Logger log = LoggerFactory.getLogger(EmailChannelListener.class);
	
	@Autowired
	private QueueService queueService;
	
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
		
		queueService.sendResponseMessage(message);
	}

}
