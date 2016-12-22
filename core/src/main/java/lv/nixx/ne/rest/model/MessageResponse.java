package lv.nixx.ne.rest.model;

import java.util.Date;

public class MessageResponse {
	
	private String correlationId = null;
	private String senderId;
	private Date timestamp;
	
	public MessageResponse() {
	}
	
	public MessageResponse(Date timestamp, String correlationId, String senderId) {
		this.senderId = senderId;
		this.correlationId = correlationId;
		this.timestamp = timestamp;
	}
	
	public String getId() {
		return correlationId;
	}

	public void setId(String id) {
		this.correlationId = id;
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

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "MessageResponse [correlationId=" + correlationId + ", senderId=" + senderId + "]";
	}
	
}
