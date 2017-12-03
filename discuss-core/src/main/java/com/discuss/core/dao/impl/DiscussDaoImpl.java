package com.discuss.core.dao.impl;


import com.discuss.core.Utils;
import com.discuss.core.dao.DiscussDao;
import com.discuss.core.dao.entity.*;
import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Person;
import com.discuss.core.dao.entity.Question;
import com.discuss.datatypes.*;
import com.discuss.datatypes.request.CommentAdditionRequest;
import com.discuss.datatypes.request.QuestionAdditionRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.*;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class DiscussDaoImpl implements DiscussDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, List<Integer> tagIds) {
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
    public List<Comment> getCommentsForQuestion(int questionId, int offset, int limit) {
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
    public Question getQuestion(int questionId) {
        Criteria criteria = this.sessionFactory.
            getCurrentSession().
            createCriteria(Question.class).
            setFetchMode("person", FetchMode.SELECT).
            add(Restrictions.eq("questionId", questionId));

        @SuppressWarnings("unchecked")
        Question question = (Question) criteria.uniqueResult();
        return question;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeQuestion(int questionId, int personId) {

        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_question_likes WHERE person_id = (:person_id) AND question_id = (:question_id)");
        query1.setParameter("person_id", personId);
        query1.setParameter("question_id", questionId);
        query1.addScalar("presence", new IntegerType());

        @SuppressWarnings(value = "unchecked")
        int count = (int) query1.uniqueResult();

        if(count > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_question_likes (person_id, question_id) VALUES (:person_id, :question_id)");
        query.setParameter("person_id", personId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeComment(int commentId, int personId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_comment_likes WHERE person_id = (:person_id) AND comment_id = :comment_id");
        query1.setParameter("person_id", personId);
        query1.setParameter("comment_id", commentId);
        query1.addScalar("presence", new IntegerType());

        @SuppressWarnings(value = "unchecked")
        int count = (int) query1.uniqueResult();

        if(count > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_comment_likes (person_id, comment_id) VALUES (:person_id, :comment_id)");
        query.setParameter("person_id", personId);
        query.setParameter("comment_id", commentId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean bookmarkQuestion(int questionId, int personId) {
        SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) as presence FROM person_question_bookmarks WHERE person_id = (:person_id) AND question_id = :question_id");
        query1.setParameter("person_id", personId);
        query1.setParameter("question_id", questionId);
        query1.addScalar("presence", new IntegerType());

        @SuppressWarnings(value = "unchecked")
        int count = (int) query1.uniqueResult();

        if(count > 0)
            return false;

        SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO person_question_bookmarks (person_id, question_id) VALUES (:person_id, :question_id)");
        query.setParameter("person_id", personId);
        query.setParameter("question_id", questionId);
        query.executeUpdate();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Comment addComment(CommentAdditionRequest commentAdditionRequest) {
        Comment comment = new Comment();
        comment.setImageId("-1");
        comment.setLikes(0);
        comment.setUpvotes(0);
        comment.setViews(0);

        comment.setText(commentAdditionRequest.getText());
        comment.setPerson(getPerson(commentAdditionRequest.getPersonId()));
        comment.setQuestion(getQuestion(commentAdditionRequest.getQuestionId()));
        comment.setTimestamp(Utils.getTimeStamp());

        this.sessionFactory.getCurrentSession().save(comment);
        return comment;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Question addQuestion(QuestionAdditionRequest questionAdditionRequest) {
        Question question = new Question();
        question.setDifficulty(questionAdditionRequest.getDifficulty());
        question.setLikes(0);
        question.setViews(0);
        if(StringUtils.isNotBlank(questionAdditionRequest.getImage())) {
            question.setImageId(questionAdditionRequest.getImage());
        }
        question.setText(questionAdditionRequest.getText());
        question.setPerson(getPerson(questionAdditionRequest.getPersonID()));
        question.setTimestamp(Utils.getTimeStamp());
        this.sessionFactory.getCurrentSession().save(question);

        return question;
    }

    @Override
    public boolean commentAlreadyExistsFor(int questionId, int personId) {
        return 0 != (long) this.sessionFactory
            .getCurrentSession()
            .createCriteria(Comment.class)
            .add(Restrictions.eq("person.personId", personId))
            .add(Restrictions.eq("question.questionId", questionId))
            .setProjection(Projections.rowCount()).uniqueResult();
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Tag> getCategoryList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Tag.class);

        @SuppressWarnings("unchecked")
        List<Tag> tags = criteria.list();
        return tags;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Person getPerson(int personId) {
        Criteria criteria = this.sessionFactory.getCurrentSession()
            .createCriteria(Person.class)
            .add(Restrictions.eq("personId", personId));

        return (Person) criteria.uniqueResult();
    }
}
