package lv.nixx.ne.rest.model;

public class InMessage {

	private String senderId;
	private String body;
	
	public InMessage(){
	}
	
	public InMessage(String senderId, String body) {
		this.senderId = senderId;
		this.body = body;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "InMessage [senderId=" + senderId + ", body=" + body + "]";
	}

}
