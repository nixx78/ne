package lv.nixx.ne.rest.tester;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

import lv.nixx.ne.TestApplication;
import lv.nixx.ne.model.Message;
import lv.nixx.ne.rest.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles(profiles="EmbededDB")
public class ScenarioTests {

	private static final String EMAIL_CHANNEL = "email.channel";
	private static final String SMS_CHANNEL = "sms.channel";
	private static final String URL_PREFIX = "http://localhost:8080/ne/";

	private final RestTemplate rt = new RestTemplate();
	
	@Autowired
	EntityManager em;
	
	@Autowired
	PlatformTransactionManager manager;

	@Before
	public void init() {
		TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
	            em.createNativeQuery("delete from ne_message").executeUpdate();
			}
	    });
	}
	
	@Test
	public void runScenario() throws InterruptedException {
		
		sendAndCheckToChannel("SBody1", SMS_CHANNEL);
		sendAndCheckToChannel("SBody2", SMS_CHANNEL);
		sendAndCheckToChannel("SBody3", SMS_CHANNEL);

		sendAndCheckToChannel("EBody1", EMAIL_CHANNEL);
		sendAndCheckToChannel("EBody2", EMAIL_CHANNEL);
		
		Thread.sleep(5000);
		
		Message[] messages = getMessages();
		assertNotNull(messages);
		
		assertEquals(2L, getMessageCountForChannel(messages, EMAIL_CHANNEL));
		assertEquals(3L, getMessageCountForChannel(messages, SMS_CHANNEL));
	}

	private void sendAndCheckToChannel(String body, String channel) {
		ResponseEntity<MessageResponse> response = sendToRest(new InMessage(getSenderRef(), body, channel));
		assertEquals(HttpStatus.OK, response.getStatusCode());
		MessageResponse rm = response.getBody();
		assertNotNull(rm);
		assertNotNull(rm.getId());
		System.out.println(rm);
	}


	private ResponseEntity<MessageResponse> sendToRest(InMessage m) {
		return rt.postForEntity(URL_PREFIX + "/inbound", m, MessageResponse.class);
	}

	private Message[] getMessages() {
		ResponseEntity<Message[]> postForEntity = rt.getForEntity(URL_PREFIX + "/statistic/messages", Message[].class);
		return postForEntity.getBody();
	}

	private String getSenderRef() {
		return "SR:" + System.currentTimeMillis();
	}
	
	private long getMessageCountForChannel(Message[] messages, String channel){
		Stream<Message> stream = Arrays.stream(messages);
		return stream.filter(m->m.getChannel().equalsIgnoreCase(channel)).count();
	}
			

}
