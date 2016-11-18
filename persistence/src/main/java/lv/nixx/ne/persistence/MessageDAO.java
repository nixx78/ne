package lv.nixx.ne.persistence;

import lv.nixx.ne.model.Message;

public interface MessageDAO {
	
	public void saveMessage(Message message);
	
}
