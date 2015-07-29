package com.sunjin.web.model;

import java.sql.Timestamp;

public class Comment {
	private int Sq;
	private int userSq;
	private int messageStatusCd;
	private int boardMessageSq;
	private Integer commentSq;
	private Timestamp insertTime;
	private Timestamp modifyTime;
	private String messageText;

	public int getSq() {
		return Sq;
	}
	public void setSq(int sq) {
		Sq = sq;
	}
	public int getUserSq() {
		return userSq;
	}
	public void setUserSq(int userSq) {
		this.userSq = userSq;
	}
	public int getMessageStatusCd() {
		return messageStatusCd;
	}
	public void setMessageStatusCd(int messageStatusCd) {
		this.messageStatusCd = messageStatusCd;
	}
	public int getBoardMessageSq() {
		return boardMessageSq;
	}
	public void setBoardMessageSq(int boardMessageSq) {
		this.boardMessageSq = boardMessageSq;
	}
	public Integer getCommentSq() {
		return commentSq;
	}
	public void setCommentSq(Integer commentSq) {
		this.commentSq = commentSq;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

}
