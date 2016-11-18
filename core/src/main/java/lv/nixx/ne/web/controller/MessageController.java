package lv.nixx.ne.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import lv.nixx.ne.rest.model.*;

@RestController
@RequestMapping("/ne")
public class MessageController {
	
	private Logger log = LoggerFactory.getLogger(MessageController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String serverInfo(){
		return "Server time " + new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(new Date());
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value ="/inbound")
	public MessageResponse processInboundMessage(@RequestBody InMessage message) {
		
		log.info("Request with message " + message);
		
		return new MessageResponse();
	}

}
