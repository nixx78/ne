package lv.nixx.ne.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lv.nixx.ne.model.Message;
import lv.nixx.ne.model.ValuesForControls;
import lv.nixx.ne.persistence.MessageDAO;

@RestController
@RequestMapping("/ne/rest/statistic")
public class StatisticController {

	@Autowired
	private MessageDAO dao;

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public @ResponseBody List<Message> getAllMessages() {
		return dao.getAllMessages();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="values_for_controls" )
	public @ResponseBody ValuesForControls getValuesForControls() {
		return dao.getValuesForControls();
	}

}
