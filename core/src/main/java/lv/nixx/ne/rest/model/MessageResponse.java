package lv.nixx.ne.rest.model;

import java.util.UUID;

public class MessageResponse {
	
	private UUID id = UUID.randomUUID();

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MessageResponse [id=" + id + "]";
	}
	
}
