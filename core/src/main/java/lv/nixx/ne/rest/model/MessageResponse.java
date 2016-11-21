package lv.nixx.ne.rest.model;


public class MessageResponse {
	
	private String correlationId = null;
	private String senderId;
	
	public MessageResponse() {
	}
	
	public MessageResponse(String correlationId, String senderId) {
		this.senderId = senderId;
		this.correlationId = correlationId;
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

	@Override
	public String toString() {
		return "MessageResponse [correlationId=" + correlationId + ", senderId=" + senderId + "]";
	}
	
}
