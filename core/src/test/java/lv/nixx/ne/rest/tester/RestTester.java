package lv.nixx.ne.rest.tester;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lv.nixx.ne.rest.model.*;

public class RestTester {

	RestTemplate rt = new RestTemplate();

	@Test
	public void sendSimpleMessage() {
		
		InMessage m = new InMessage("SenderRef1", "MessageBody");
		ResponseEntity<MessageResponse> response = rt.postForEntity("http://localhost:8080/ne/inbound", m, MessageResponse.class);
		
		//ResponseEntity<MessageResponse> response = rt.postForEntity("http://localhost:8080/core-0.0.1-SNAPSHOT/ne/inbound", m, MessageResponse.class);
		
		
		
		System.out.println(response);
		
	}

}
