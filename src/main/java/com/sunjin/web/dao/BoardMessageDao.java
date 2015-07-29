package com.sunjin.web.dao;

import java.util.List;
import com.sunjin.web.model.BoardMessage;

public interface BoardMessageDao {
	public List<BoardMessage> getAllBoardMessageList();
	public List<BoardMessage> getPostingBoardMessageList();
	public List<BoardMessage> getPostingBoardMessageListByPage(int pageNum);
	public int getPostingBoardMessageSize();
	public int getPostingBoardMessagePageSize();
	
	
	public BoardMessage getBoardMessageById(int id);  
	//public int insertBoardMessage(BoardMessage boardMessage);    
	public void insertOrUpdateBoardMessage(BoardMessage boardMessage);    
	public void deleteBoardMessage(int id);  

	 
}
