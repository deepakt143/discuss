package com.discuss.core.dao.impl;


import com.discuss.core.dao.DiscussDao;
import com.discuss.core.dao.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
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
    public List<Question> getQuestions(String category, int offset, int limit, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(QuestionTag.class).
            createAlias("tag", "tg").
            add(Restrictions.eq("tg.tagId", category)).
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
            createAlias("ownerUser", "usr").
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
    public boolean upvoteQuestion(String questionId, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(UserQuestionLikes.class).
            createAlias("user", "usr").
            createAlias("question", "ques").
            add(Restrictions.eq("usr.userId", userId)).
            add(Restrictions.eq("ques.questionId", questionId));

        @SuppressWarnings("unchecked")
        List<UserQuestionLikes> questions = criteria.list();
        if(CollectionUtils.isNotEmpty(questions))
            return false;
        User user = getUser(userId);
        Question question = getQuestion(questionId, null);
        UserQuestionLikes userQuestionLikes = new UserQuestionLikes();
        userQuestionLikes.setQuestion(question);
        userQuestionLikes.setUser(user);
        this.sessionFactory.getCurrentSession().saveOrUpdate(userQuestionLikes);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean upvoteComment(String commentId, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(UserCommentLikes.class).
            createAlias("user", "usr").
            createAlias("comment", "comment").
            add(Restrictions.eq("usr.userId", userId)).
            add(Restrictions.eq("comment.commentId", commentId));

        @SuppressWarnings("unchecked")
        List<UserCommentLikes> questions = criteria.list();
        if(CollectionUtils.isNotEmpty(questions))
            return false;
        User user = getUser(userId);
        Comment comment = getComment(commentId);
        UserCommentLikes userCommentLikes = new UserCommentLikes();
        userCommentLikes.setComment(comment);
        userCommentLikes.setUser(user);
        this.sessionFactory.getCurrentSession().saveOrUpdate(userCommentLikes);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(UserQuestionBookmarks.class).
            createAlias("user", "usr").
            createAlias("question", "ques").
            add(Restrictions.eq("usr.userId", userId)).
            add(Restrictions.eq("ques.questionId", questionId));

        @SuppressWarnings("unchecked")
        List<UserQuestionBookmarks> questions = criteria.list();
        if(CollectionUtils.isNotEmpty(questions))
            return false;
        User user = getUser(userId);
        Question question = getQuestion(questionId, null);
        UserQuestionBookmarks userQuestionBookmarks = new UserQuestionBookmarks();
        userQuestionBookmarks.setQuestion(question);
        userQuestionBookmarks.setUser(user);
        this.sessionFactory.getCurrentSession().saveOrUpdate(userQuestionBookmarks);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User getUser(String userId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(User.class).
            add(Restrictions.eq("userId", userId));

        @SuppressWarnings("unchecked")
        User user = (User) criteria.uniqueResult();
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Comment getComment(String commentId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Comment.class).
            add(Restrictions.eq("commentId", commentId));

        @SuppressWarnings("unchecked")
        Comment comment = (Comment) criteria.uniqueResult();
        return comment;
    }
}
