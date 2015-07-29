package com.sunjin.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunjin.web.model.BoardMessage;
import com.sunjin.web.model.Comment;

@Repository("CommentDao")
public class CommentDaoImpl implements CommentDao{
	private SessionFactory sessionFactory;

	public CommentDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@Transactional
	public List<Comment> getAllCommnetList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Comment> getPostingCommnetList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Comment> getPostingCommnetListByPage(int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int getPostingCommnetSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int getPostingCommnetPageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public Comment getCommnetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void insertOrUpdateCommnet(Comment Commnet) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Commnet);
	
	}

	@Override
	@Transactional
	public void deleteCommnet(int id) {
		// TODO Auto-generated method stub	
	}

	@Override
	@Transactional
	public List<Comment> getPostingCommnetListByBoardId(int boardId) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Comment.class);

		criteria.add(Restrictions.eq("messageStatusCd", 1));
		criteria.add(Restrictions.eq("boardMessageSq", boardId));
		
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listComment;
	}
	
	@Override
	@Transactional
	public List<Comment> getPostingCommnetListByCommentId(int boardId, int commentId) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Comment.class);

		criteria.add(Restrictions.eq("messageStatusCd", 1));
		criteria.add(Restrictions.eq("boardMessageSq", boardId));
		
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listComment;
	}
}
