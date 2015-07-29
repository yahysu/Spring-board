package com.sunjin.web.model;

import java.sql.Timestamp;
import org.springframework.web.util.HtmlUtils;


public class BoardMessage {

	private int messageSq;
	private int userSq;
	private int messageStatusCd;
	private Timestamp insertTime;
	private Timestamp modifyTime;
	private String messageTitle;
	private String messageText;

	public int getMessageSq() {
		return messageSq;
	}
	public void setMessageSq(int messageSq) {
		this.messageSq = messageSq;
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
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public void convertHtmlEscape()
	{
		this.messageText = HtmlUtils.htmlEscape(messageText);
		this.messageText = messageText.replace("\r\n", "<br>");
		
		this.messageTitle = HtmlUtils.htmlEscape(messageTitle);
		this.messageTitle = messageTitle.replace("\r\n", "<br>");
	}
}
