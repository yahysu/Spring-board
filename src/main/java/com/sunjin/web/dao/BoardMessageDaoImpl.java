package com.sunjin.web.dao;


import java.util.List;

import com.sunjin.web.model.BoardMessage;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("BoardMessageDao")
public class BoardMessageDaoImpl implements BoardMessageDao {
	private SessionFactory sessionFactory;
	private static final int MAX_BOARD_MESSAGE_CNT_PER_PAGE= 10;

	public BoardMessageDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<BoardMessage> getAllBoardMessageList() {
		@SuppressWarnings("unchecked")
		List<BoardMessage> listBoardMessage = (List<BoardMessage>) sessionFactory.getCurrentSession()
		.createCriteria(BoardMessage.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listBoardMessage;
	}

	@Override
	@Transactional
	public List<BoardMessage> getPostingBoardMessageList() {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(BoardMessage.class);

		criteria.add(Restrictions.eq("messageStatusCd", 1));
		@SuppressWarnings("unchecked")
		List<BoardMessage> listBoardMessage = (List<BoardMessage>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();


		return listBoardMessage;
	}

	@Override
	@Transactional
	public List<BoardMessage> getPostingBoardMessageListByPage(int pageNum) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(BoardMessage.class);

		criteria.add(Restrictions.eq("messageStatusCd", 1));
		criteria.setFirstResult(MAX_BOARD_MESSAGE_CNT_PER_PAGE*pageNum);
		criteria.setMaxResults(MAX_BOARD_MESSAGE_CNT_PER_PAGE);

		System.out.println("criteria:"+ criteria);
		
		@SuppressWarnings("unchecked")
		List<BoardMessage> listBoardMessage = (List<BoardMessage>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();


		return listBoardMessage;
	}

	@Override
	@Transactional
	public int getPostingBoardMessageSize() {
		int bmSize =0;
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(BoardMessage.class);
		criteria.add(Restrictions.eq("messageStatusCd", 1));

		bmSize = ((Long) criteria.setProjection(Projections.count("messageSq")).uniqueResult()).intValue();

		System.out.println(bmSize);
		return bmSize;
	}

	@Override
	@Transactional
	public int getPostingBoardMessagePageSize() {
		int pageSize =0;

		int bmSize = getPostingBoardMessageSize();
		try{
			pageSize = bmSize/MAX_BOARD_MESSAGE_CNT_PER_PAGE;
			if(bmSize % MAX_BOARD_MESSAGE_CNT_PER_PAGE == 0)
				pageSize = pageSize-1;
		}
		catch(Exception e)
		{
			
		}

		System.out.println(pageSize);
		return pageSize;
	}

	@Override
	@Transactional
	public BoardMessage getBoardMessageById(int id) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(BoardMessage.class);
		criteria.add(Restrictions.eq("messageSq", id));

		return (BoardMessage) criteria.uniqueResult();
	}

	@Override
	@Transactional
	public void insertOrUpdateBoardMessage(BoardMessage boardMessage) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(boardMessage);
	}

	@Override
	@Transactional
	public void deleteBoardMessage(int id) {
		BoardMessage boardToDelete = new BoardMessage();
		boardToDelete.setUserSq(id);
		sessionFactory.getCurrentSession().delete(boardToDelete);
	}
}