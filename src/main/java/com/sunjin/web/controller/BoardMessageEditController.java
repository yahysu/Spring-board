package com.sunjin.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunjin.web.dao.BoardMessageDao;
import com.sunjin.web.model.BoardMessage;

@Controller
public class BoardMessageEditController {
	@Autowired
	private BoardMessageDao boardMessageDao;

	@RequestMapping("/board_edit")
	public ModelAndView editBoardMessage(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		ModelAndView model = new ModelAndView("board_edit");

		if(id != 0)
		{
			BoardMessage boardMessage = boardMessageDao.getBoardMessageById(id);
			model.addObject("boardMessageForm", boardMessage);
		}
		else
		{
			model.addObject("boardMessageForm", new BoardMessage());
		}
		//returns the view name
		return model;

	}
}
