package lv.nixx.ne.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.*;
import org.springframework.stereotype.Component;

import lv.nixx.ne.model.Message;
import lv.nixx.ne.model.Status;

@Component
@Transactional
public class MessageDAOImpl implements MessageDAO {

	private Logger log = LoggerFactory.getLogger(MessageDAOImpl.class);
	
    @PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveMessage(Message message) {
		log.debug("Save message {} in database", message);
		em.persist(message);
	}

	@Override
	public void setMessageState(String id, Status status) {

		Query q = em.createNamedQuery("Message.changeStatusQuery");
		q.setParameter("id", id);
		q.setParameter("status", status);
		q.executeUpdate();
		
		log.debug("Message, ID {} status changed to {}", id, status);
	}
	
	@Override
	public List<Message> getAllMessages() {
		TypedQuery<Message> tq = em.createNamedQuery("Message.getAll", Message.class);
		return tq.getResultList();
	}

}
