package com.discuss.core.dao.impl;


import com.discuss.core.dao.DiscussDao;
import com.discuss.core.dao.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
public class DiscussDaoImpl implements DiscussDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getQuestions(int categoryId, int offset, int limit, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(QuestionTag.class).
            createAlias("tag", "tg").
            createAlias("question", "ques").
            add(Restrictions.eq("tg.tagId", categoryId)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Comment.class).
            createAlias("question", "qs").
            createCriteria("user", "usr").
            add(Restrictions.eq("qs.questionId", questionId)).
            setFirstResult(offset).
            setMaxResults(limit);
       @SuppressWarnings("unchecked")
        List<Comment> comments = criteria.list();
        return comments;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(UserQuestionBookmarks.class).
            createAlias("user", "usr").
            createAlias("question", "qs").
            add(Restrictions.eq("usr.userId", userId)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Comment> getUserAddedComments(int offset, int limit, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Comment.class).
            createAlias("question", "ques").
            createAlias("user", "usr").
            add(Restrictions.eq("usr.userId", userId)).
            setFirstResult(offset).
            setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Comment> comments = criteria.list();
        return comments;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Question getQuestion(String questionId, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Question.class).
            add(Restrictions.eq("questionId", questionId));

        @SuppressWarnings("unchecked")
        Question question = (Question) criteria.uniqueResult();
        return question;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeQuestion(String questionId, String userId) {

        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM user_question_likes WHERE user_id = (:user_id) AND question_id = :question_id");
        query1.setParameter("user_id", userId);
        query1.setParameter("question_id", questionId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0)  > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO user_question_likes (user_id, question_id) VALUES (:user_id, :question_id)");
        query.setParameter("user_id", userId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeComment(String commentId, String userId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM user_comment_likes WHERE user_id = (:user_id) AND comment_id = :comment_id");
        query1.setParameter("user_id", userId);
        query1.setParameter("comment_id", commentId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0) > 0)
            return false;


        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO user_comment_likes (user_id, comment_id) VALUES (:user_id, :comment_id)");
        query.setParameter("user_id", userId);
        query.setParameter("comment_id", commentId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM user_question_bookmarks WHERE user_id = (:user_id) AND question_id = :question_id");
        query1.setParameter("user_id", userId);
        query1.setParameter("question_id", questionId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0) > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO user_question_bookmarks (user_id, question_id) VALUES (:user_id, :question_id)");
        query.setParameter("user_id", userId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }
}
