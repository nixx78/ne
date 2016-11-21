package lv.nixx.ne.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lv.nixx.ne.model.Message;
import lv.nixx.ne.persistence.MessageDAO;

@RestController
@RequestMapping("/ne/statistic")
public class StatisticController {

	@Autowired
	private MessageDAO dao;

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public @ResponseBody List<Message> getAllMessages() {
		return dao.getAllMessages();
	}

}
