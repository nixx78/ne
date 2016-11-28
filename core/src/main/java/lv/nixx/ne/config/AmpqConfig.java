package lv.nixx.ne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Configuration
public class AmpqConfig {

	final static String inboundMessageQueue = "inbound-message-queue";
	final static String inboundMessageExchange = "inbound-message-exchange";
	final static String channelResponseMessageExchange = "channelResponseMessageExchange";
	
	final static String outgoingMessageExchange = "outgoing-message-exchange";
	
	final static String emailChannelQueue = "email-channel-queue";
	final static String smsChannelQueue = "sms-channel-queue";
	final static String channelResponseQueue = "channel-response-queue";

	
	@Bean
	List<Queue> qs() {
		return Arrays.asList(
				new Queue(inboundMessageQueue, false),
				new Queue(emailChannelQueue, false),
				new Queue(smsChannelQueue, false),
				new Queue(channelResponseQueue, false)
		);
	}
	
    @Bean
    List<Exchange> es() {
    	return Arrays.asList(
    			new TopicExchange(inboundMessageExchange),
    			new TopicExchange(outgoingMessageExchange),
    			new TopicExchange(channelResponseMessageExchange)
    	);
    }

    @Bean
    List<Binding> bs() {
    	return Arrays.asList(
   			new Binding(inboundMessageQueue, DestinationType.QUEUE, inboundMessageExchange, inboundMessageQueue, null),
   			new Binding(emailChannelQueue, DestinationType.QUEUE, outgoingMessageExchange, "email.channel", null),
   			new Binding(smsChannelQueue, DestinationType.QUEUE, outgoingMessageExchange, "sms.channel", null),
   			new Binding(channelResponseQueue, DestinationType.QUEUE, channelResponseMessageExchange, channelResponseQueue, null)
    	);
    }

	
	@Bean
	ConnectionFactory connectionFactory() {
	    CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    connectionFactory.setUsername("guest");
	    connectionFactory.setPassword("guest");
	    return connectionFactory;
	}

	@Bean
	RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}
	
	@Bean
	RabbitAdmin ampqAdmin() {
		return new RabbitAdmin(connectionFactory());
	}
	
	@Bean
	SimpleRabbitListenerContainerFactory emailChannelContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(2);
		return factory;
	}

}

