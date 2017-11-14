package com.discuss.core;

import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Question;

import java.util.function.Function;

/**
 * @author Deepak Thakur
 */
public class ServiceDaoEntityMapper {

    public static Function<Comment, com.discuss.datatypes.Comment> commentMapper = comment -> new com.discuss.datatypes.Comment.CommentBuilder().
        setCommentId(comment.getCommentId()).
        setText(comment.getText()).
        setLikes(comment.getLikes()).
        setViews(comment.getViews()).
        setPersonId(comment.getPerson().getPersonId()).
        setPersonName(comment.getPerson().getName()).build();
    public static Function<Question, com.discuss.datatypes.Question> questionMapper = question -> new com.discuss.datatypes.Question.QuestionBuilder().
        setQuestionId(question.getQuestionId()).
        setText(question.getText()).
        setLikes(question.getLikes()).
        setViews(question.getViews()).
        setPersonId(question.getPerson().getPersonId()).
        setPersonName(question.getPerson().getName()).
        build();
}
