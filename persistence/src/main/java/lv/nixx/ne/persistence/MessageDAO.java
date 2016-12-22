package lv.nixx.ne.persistence;

import java.util.List;

import lv.nixx.ne.model.Message;
import lv.nixx.ne.model.Status;
import lv.nixx.ne.model.ValuesForControls;

public interface MessageDAO {
	
	public void saveMessage(Message message);
	public void setMessageState(String id, Status status);
	public List<Message> getAllMessages();
	public ValuesForControls getValuesForControls();
}
