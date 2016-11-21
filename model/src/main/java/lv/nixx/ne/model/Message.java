package lv.nixx.ne.model;

import javax.persistence.*;

@Entity
@Table(name="ne_message")
@NamedQueries(value = { 
		@NamedQuery(name = "Message.changeStatusQuery", query = "update Message set status = :status where id = :id"),
		@NamedQuery(name = "Message.getAll", query = "select m from Message m")
})
public class Message {
	

	@Id
	@Column(name="correlation_id", columnDefinition="VARCHAR(100)")
	private String id;
	
	@Column(name="sender_id")
	private String senderId;
	
	@Column(name="source")
	private String source;
	
	@Column(name="channel")
	private String channel;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.NEW;
	
	public Message() {
	}
	
	public Message(String id, String senderId, String source) {
		this.id = id;
		this.senderId = senderId;
		this.source = source;
	}
	
	public String getChannel() {
		return channel;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getId() {
		return id.toString();
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getSource() {
		return source;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", senderId=" + senderId + ", source=" + source + ", channel=" + channel + ", status=" + status + "]";
	}

}
