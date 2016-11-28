package lv.nixx.ne.integration.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lv.nixx.ne.rest.model.*;

public class RestTester {

	final RestTemplate rt = new RestTemplate();

	@Test
	@Ignore
	public void sendMessage_EmailChannelMultiple() {

		int count = 1000;
		for (int i = 0; i < count; i++) {
			InMessage m = new InMessage(getSenderRef() + i, "MessageBody", "email.channel");
			sendToRest(m);
		}
	}

	@Test
	public void sendMessage_smsChannel() {

		sendAndCheckToSMSChannel();
		
		
	}

	private void sendAndCheckToSMSChannel() {
		ResponseEntity<MessageResponse> response = sendToRest(new InMessage(getSenderRef(), "MessageBody", "sms.channel"));
		assertEquals(HttpStatus.OK, response.getStatusCode());
		MessageResponse body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getId());
		System.out.println(response);
	}

	@Test
	public void sendMessage_EmailChannel() {
		InMessage m = new InMessage(getSenderRef(), "MessageBody", "email.channel");
		ResponseEntity<MessageResponse> response = sendToRest(m);

		System.out.println(response);
	}

	private ResponseEntity<MessageResponse> sendToRest(InMessage m) {
		return rt.postForEntity("http://localhost:8080/ne/inbound", m, MessageResponse.class);
	}

	private String getSenderRef() {
		return "SR:" + System.currentTimeMillis();
	}

}
