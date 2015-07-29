package com.sunjin.web.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sunjin.web.dao.BoardMessageDao;
import com.sunjin.web.model.BoardMessage;

@Controller
@RequestMapping(value ="/board_submit")
public class BoardMessageSubmitController {
	@Autowired
	private BoardMessageDao boardMessageDao;

	/*
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editBoardMessage(@ModelAttribute BoardMessage boardMessage) {
		BoardMessage boardForm = new BoardMessage();    
		ModelAndView model = new ModelAndView("board_edit_result");

		return model;
	}
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editBoardMessage(@ModelAttribute("boardMessageForm") BoardMessage boardForm)
	{
		if (boardForm.getUserSq() == 0)	boardForm.setUserSq(1);	//test 나중에 알수 없는 error?
		if (boardForm.getMessageStatusCd() == 0) boardForm.setMessageStatusCd(1); //test 나중에 알수 없는 error?

		boardMessageDao.insertOrUpdateBoardMessage(boardForm);

		String redirectUrl = "";

		// boardForm.getMessageStatusCd() ==2, 3 은 게시글 삭제된 상태 나중에 상태코드에서 불러와서 비교해야함(1이 게시된 상태)
		if (boardForm.getMessageSq() == 0 || boardForm.getMessageStatusCd() != 1 ) redirectUrl = "redirect:board_list";
		else redirectUrl = "redirect:board_view?id="+boardForm.getMessageSq();
		ModelAndView model = new ModelAndView(redirectUrl);

		return model;

	}
}
