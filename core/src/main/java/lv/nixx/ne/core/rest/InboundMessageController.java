package lv.nixx.ne.core.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lv.nixx.ne.model.Message;
import lv.nixx.ne.persistence.MessageDAO;
import lv.nixx.ne.queue.QueueService;
import lv.nixx.ne.rest.model.*;

@RestController
@RequestMapping("/ne/rest")
public class InboundMessageController {
	
	private Logger log = LoggerFactory.getLogger(InboundMessageController.class);
	
	@Autowired
	private QueueService queueService;
	
	@Autowired
	private MessageDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String serverInfo(){
		return "Server time " + new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(new Date());
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/inbound")
	public @ResponseBody MessageResponse processInboundMessage(@RequestBody InMessage inMessage) {

		inMessage.setCorrelationId(UUID.randomUUID().toString());
		
		Message dbMessage = new Message(inMessage.getCorrelationId(), inMessage.getSenderId(), "Source");
		dbMessage.setChannel(inMessage.getChannel());
		dbMessage.setTimestamp(new Date());
		dbMessage.setSourceBody(inMessage.getBody());
		
		dao.saveMessage(dbMessage);

		log.info("Request with message " + inMessage);

		queueService.sendMessageToInboundQueue(inMessage);
		
		return new MessageResponse(inMessage.getCorrelationId(), inMessage.getSenderId());
	}

}
