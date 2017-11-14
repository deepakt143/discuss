package com.discuss.core.dao.impl;


import com.discuss.core.dao.DiscussDao;
import com.discuss.core.dao.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
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
    public List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, int personId, List<Integer> tagIds) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(QuestionTag.class).
            add(Restrictions.in("tag.tagId", tagIds)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Comment> getCommentsForQuestion(int questionId, int offset, int limit, int personId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Comment.class).
            add(Restrictions.eq("question.questionId", questionId)).
            setFirstResult(offset).
            setMaxResults(limit);

        @SuppressWarnings("unchecked")
        List<Comment> comments = criteria.list();
        return comments;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, int personId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(PersonQuestionBookmarks.class).
            add(Restrictions.eq("person.personId", personId)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getLikedQuestions(int offset, int limit, int personId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(PersonQuestionLikes.class).
            add(Restrictions.eq("person.personId", personId)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);

        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getQuestionsCommented(int offset, int limit, int personId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Comment.class).
            add(Restrictions.eq("person.personId", personId)).
            setProjection(Projections.projectionList().add(Property.forName("question"))).
            setFirstResult(offset).
            setMaxResults(limit);

        @SuppressWarnings("unchecked")
        List<Question> questions = criteria.list();
        return questions;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Question getQuestion(int questionId, int personId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Question.class).
            setFetchMode("person", FetchMode.JOIN).
            add(Restrictions.eq("questionId", questionId));

        @SuppressWarnings("unchecked")
        Question question = (Question) criteria.uniqueResult();
        return question;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeQuestion(String questionId, String personId) {

        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_question_likes WHERE person_id = (:person_id) AND question_id = :question_id");
        query1.setParameter("person_id", personId);
        query1.setParameter("question_id", questionId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0)  > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_question_likes (person_id, question_id) VALUES (:person_id, :question_id)");
        query.setParameter("person_id", personId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeComment(String commentId, String personId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_comment_likes WHERE person_id = (:person_id) AND comment_id = :comment_id");
        query1.setParameter("person_id", personId);
        query1.setParameter("comment_id", commentId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0) > 0)
            return false;


        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_comment_likes (person_id, comment_id) VALUES (:person_id, :comment_id)");
        query.setParameter("person_id", personId);
        query.setParameter("comment_id", commentId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean bookmarkQuestion(String questionId, int personId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_question_bookmarks WHERE person_id = (:person_id) AND question_id = :question_id");
        query1.setParameter("person_id", personId);
        query1.setParameter("question_id", questionId);
        query1.addEntity("presence", Integer.class);

        @SuppressWarnings(value = "unchecked")
        List<Integer> list = query1.list();

        if(CollectionUtils.isNotEmpty(list) && list.get(0) > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_question_bookmarks (person_id, question_id) VALUES (:person_id, :question_id)");
        query.setParameter("person_id", personId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Tag> getQuestionCategoriesForPerson(int personId) {
        Criteria criteria = this.sessionFactory
            .getCurrentSession()
            .createCriteria(PersonTagInterests.class)
            .add(Restrictions.eq("person.personId", personId))
            .setProjection(Projections.projectionList().add(Property.forName("tag")));

        @SuppressWarnings("unchecked")
        List<Tag> tags = criteria.list();
        return tags;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean isQuestionLikedByPerson(int questionId, int personId) {
        return 0 != (long) this.sessionFactory
            .getCurrentSession()
            .createCriteria(PersonQuestionLikes.class)
            .add(Restrictions.eq("person.personId", personId))
            .add(Restrictions.eq("question.questionId", questionId))
            .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean isQuestionBookmarkedByPerson(int questionId, int personId) {
        return 0 != (long) this.sessionFactory
            .getCurrentSession()
            .createCriteria(PersonQuestionBookmarks.class)
            .add(Restrictions.eq("person.personId", personId))
            .add(Restrictions.eq("question.questionId", questionId))
            .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean isCommentLikedByPerson(int commentId, int personId) {
        return 0 != (long) this.sessionFactory
            .getCurrentSession()
            .createCriteria(PersonCommentLikes.class)
            .add(Restrictions.eq("person.personId", personId))
            .add(Restrictions.eq("comment.commentId", commentId))
            .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Comment getPersonAddedCommentOnQuestion(int questionId, int personId) {
        Criteria criteria = this.sessionFactory
            .getCurrentSession()
            .createCriteria(Comment.class)
            .add(Restrictions.eq("question.questionId", questionId))
            .add(Restrictions.eq("person.personId", personId));

        @SuppressWarnings("unchecked")
        List<Comment> comments = criteria.list();
        if(CollectionUtils.isEmpty(comments))
            return null;
        return comments.get(0);
    }
}
