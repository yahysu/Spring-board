package com.sunjin.web.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sunjin.web.dao.BoardMessageDao;
import com.sunjin.web.dao.CommentDao;
import com.sunjin.web.model.BoardMessage;
import com.sunjin.web.model.Comment;

@Controller
@RequestMapping(value ="/comment_submit")
public class CommentSubmitController {
	@Autowired
	private CommentDao commentDao;

	/*
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editBoardMessage(@ModelAttribute BoardMessage boardMessage) {
		BoardMessage boardForm = new BoardMessage();    
		ModelAndView model = new ModelAndView("board_edit_result");

		return model;
	}
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editComment(@ModelAttribute("commentForm") Comment commentForm)
	{
		// for testing purpose:
		System.out.println("1: " + commentForm.getSq());
		System.out.println("2: " + commentForm.getInsertTime());
		System.out.println("3: " + commentForm.getMessageText());
		System.out.println("boardid: " + commentForm.getBoardMessageSq());
		System.out.println("5: " + commentForm.getUserSq());
		
		if (commentForm.getUserSq() == 0)	commentForm.setUserSq(1);	//test 나중에 알수 없는 error?
		if (commentForm.getMessageStatusCd() == 0) commentForm.setMessageStatusCd(1); //test 나중에 알수 없는 error?
		
		commentDao.insertOrUpdateCommnet(commentForm);
		
		String redirectUrl = "redirect:comment_list?board_id="+commentForm.getBoardMessageSq();
		
		/*
		// boardForm.getMessageStatusCd() ==2, 3 은 게시글 삭제된 상태 나중에 상태코드에서 불러와서 비교해야함(1이 게시된 상태)
		if (commentForm.() == 0 || commentForm.getMessageStatusCd() != 1 ) redirectUrl = "redirect:board_list";
		else redirectUrl = "redirect:board_view?id="+commentForm.getMessageSq();
	   */
		
		ModelAndView model = new ModelAndView(redirectUrl);
		
		return model;

	}
}
