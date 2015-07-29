package com.sunjin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunjin.web.dao.BoardMessageDao;
import com.sunjin.web.dao.CommentDao;
import com.sunjin.web.model.BoardMessage;
import com.sunjin.web.model.Comment;

@Controller
public class CommentListController {
	@Autowired
	private CommentDao commentDao;

	
	//리스트 뽑을 때, board에 있는 모든 리스트 뽑고
	//리스트 다 뽑았는데, 대댓글은 어떻게 뽑지 / DBconnection은 한번만하고..? 뽑힌 리스트에서?
	//어떻게 인덱싱 처리하지..
	@RequestMapping("/comment_list")
	 public ModelAndView showCommentListView(@RequestParam(value="board_id", required=false, defaultValue="0") int board_id) {
		 List<Comment> listComment = commentDao.getPostingCommnetListByBoardId(board_id);
		 System.out.println(listComment.size());
		 ModelAndView model = new ModelAndView("comment_list");
		 model.addObject("listComment", listComment);
		 model.addObject("commentForm", new Comment());
		 model.addObject("board_id", board_id);
		 
			
			
	   //returns the view name
	   return model;
	 
	 }
}
