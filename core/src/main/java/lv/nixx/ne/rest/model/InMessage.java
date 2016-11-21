package lv.nixx.ne.rest.model;

import java.io.Serializable;

public class InMessage implements Serializable {

	private static final long serialVersionUID = -3771164109007799338L;
	
	private String senderId;
	private String body;
	private String channel;
	private String correlationId;
	
	public InMessage(){
	}
	
	public InMessage(String senderId, String body, String channel) {
		this.senderId = senderId;
		this.body = body;
		this.channel = channel;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getBody() {
		return body;
	}
	
	public String getChannel() {
		return channel;
	}

	@Override
	public String toString() {
		return "InMessage [senderId=" + senderId + ", body=" + body + ", channel=" + channel + "]";
	}
	
}
