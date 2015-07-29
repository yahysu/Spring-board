package com.sunjin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunjin.web.model.BoardMessage;
import com.sunjin.web.dao.BoardMessageDao;
@Controller
public class BoardListController {

	@Autowired
	private BoardMessageDao boardMessageDao;

	@RequestMapping("/board_list")
	public ModelAndView showBoardListView(@RequestParam(value="pageNum", required=false, defaultValue="0") int pageNum) {
		List<BoardMessage> listBoardMessage = boardMessageDao.getPostingBoardMessageListByPage(pageNum);
		ModelAndView model = new ModelAndView("board_list");
		
		for(BoardMessage bm : listBoardMessage)
			bm.convertHtmlEscape();

		model.addObject("listBoardMessage", listBoardMessage);
		
		int pageSize = boardMessageDao.getPostingBoardMessagePageSize();
		
		
		model.addObject("pageSize", pageSize);
		model.addObject("pageNum", pageNum);
		
		//returns the view name
		return model;

	}
}
