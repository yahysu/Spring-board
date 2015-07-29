package com.sunjin.web.dao;

import java.util.List;

import com.sunjin.web.model.Comment;

public interface CommentDao {
	public List<Comment> getAllCommnetList();
	public List<Comment> getPostingCommnetList();
	public List<Comment> getPostingCommnetListByBoardId(int boardId);
	public List<Comment> getPostingCommnetListByPage(int pageNum);
	public List<Comment> getPostingCommnetListByCommentId (int boardId, int commentId);
	public int getPostingCommnetSize();
	public int getPostingCommnetPageSize();
	
	
	public Comment getCommnetById(int id);  
	//public int insertCommnet(Commnet Commnet);    
	public void insertOrUpdateCommnet(Comment Commnet);    
	public void deleteCommnet(int id);  

	
}
