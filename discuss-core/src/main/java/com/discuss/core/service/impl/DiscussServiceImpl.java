package com.discuss.core.service.impl;


import com.discuss.core.ServiceDaoEntityMapper;
import com.discuss.core.Utils;
import com.discuss.core.dao.DiscussDao;
import com.discuss.core.dao.ImageStore;
import com.discuss.core.dao.entity.Tag;
import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.request.CommentAdditionRequest;
import com.discuss.datatypes.request.QuestionAdditionRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Deepak Thakur
 */
@Service
public class DiscussServiceImpl implements DiscussService {

    private final DiscussDao discussDao;
    private final ImageStore imageStore;
    private static final List<Question> EMPTY_QUESTION_LIST = ImmutableList.of();
    private static final List<Comment> EMPTY_COMMENT_LIST = ImmutableList.of();
    private static final List<Category> EMPTY_CATEGORY_LIST = ImmutableList.of();

    @Autowired
    public DiscussServiceImpl(DiscussDao discussDao, ImageStore imageStore) {
        this.discussDao = discussDao;
        this.imageStore = imageStore;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getQuestions(String sortBy,
                                       String sortOrder,
                                       int offset,
                                       int limit,
                                       int personId) {
        List<Tag> tags = discussDao.getQuestionCategoriesForPerson(personId);

        if(CollectionUtils.isEmpty(tags))
            return EMPTY_QUESTION_LIST;

        List<com.discuss.core.dao.entity.Question> questionEntities = discussDao.getQuestions(sortBy, sortOrder, offset, limit, tags.stream().map(Tag::getTagId).collect(Collectors.toList()));

        List<Question> questionList = CollectionUtils.isEmpty(questionEntities) ? EMPTY_QUESTION_LIST : questionEntities.stream().map(ServiceDaoEntityMapper.questionMapper).collect(Collectors.toList());
        questionList.stream().forEach(question -> {
            question.setLiked(discussDao.isQuestionLikedByPerson(question.getQuestionId(), personId));
            question.setBookmarked(discussDao.isQuestionBookmarkedByPerson(question.getQuestionId(), personId));
        });

        return questionList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Comment> getCommentsForQuestion(int questionId,
                                                String sortBy,
                                                String sortOrder,
                                                int offset,
                                                int limit,
                                                int personId) {
        List<com.discuss.core.dao.entity.Comment> commentEntities = discussDao.getCommentsForQuestion(questionId, offset, limit);
        List<Comment> commentList = CollectionUtils.isEmpty(commentEntities) ? EMPTY_COMMENT_LIST : commentEntities.stream().map(ServiceDaoEntityMapper.commentMapper).collect(Collectors.toList());
        commentList.stream().forEach(comment -> {
            comment.setLiked(discussDao.isCommentLikedByPerson(comment.getCommentId(), personId));
        });

        return commentList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, int personId) {
        List<com.discuss.core.dao.entity.Question> questionEntities = discussDao.getBookMarkedQuestions(offset, limit, personId);
        List<Question> questionList = CollectionUtils.isEmpty(questionEntities) ? EMPTY_QUESTION_LIST : questionEntities.stream().map(ServiceDaoEntityMapper.questionMapper).collect(Collectors.toList());
        questionList.stream().forEach(question -> {
            question.setLiked(discussDao.isQuestionLikedByPerson(question.getQuestionId(), personId));
            question.setBookmarked(discussDao.isQuestionBookmarkedByPerson(question.getQuestionId(), personId));
        });

        return questionList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getLikedQuestions(int offset, int limit, int personId) {
        List<com.discuss.core.dao.entity.Question> questionEntities = discussDao.getLikedQuestions(offset, limit, personId);
        List<Question> questionList = CollectionUtils.isEmpty(questionEntities) ? EMPTY_QUESTION_LIST : questionEntities.stream().map(ServiceDaoEntityMapper.questionMapper).collect(Collectors.toList());
        questionList.stream().forEach(question -> {
            question.setLiked(discussDao.isQuestionLikedByPerson(question.getQuestionId(), personId));
            question.setBookmarked(discussDao.isQuestionBookmarkedByPerson(question.getQuestionId(), personId));
        });

        return questionList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Question> getQuestionsCommented(int offset, int limit, int personId) {
        List<com.discuss.core.dao.entity.Question> questionEntities = discussDao.getQuestionsCommented(offset, limit, personId);
        List<Question> questionList = CollectionUtils.isEmpty(questionEntities) ? EMPTY_QUESTION_LIST : questionEntities.stream().map(ServiceDaoEntityMapper.questionMapper).collect(Collectors.toList());
        questionList.stream().forEach(question -> {
            question.setLiked(discussDao.isQuestionLikedByPerson(question.getQuestionId(), personId));
            question.setBookmarked(discussDao.isQuestionBookmarkedByPerson(question.getQuestionId(), personId));
        });

        return questionList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Comment getPersonAddedCommentOnQuestion(int questionId, int personId) {
        com.discuss.core.dao.entity.Comment comment = discussDao.getPersonAddedCommentOnQuestion(questionId, personId);
        if(comment == null)
            return null;
        Comment comment1 = ServiceDaoEntityMapper.commentMapper.apply(comment);
        comment1.setLiked(discussDao.isCommentLikedByPerson(comment1.getCommentId(), personId));
        return comment1;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Question getQuestion(int questionId, int personId) {
        com.discuss.core.dao.entity.Question question = discussDao.getQuestion(questionId);
        if(null != question) {
            Question question1 = ServiceDaoEntityMapper.questionMapper.apply(question);
            question1.setLiked(discussDao.isQuestionLikedByPerson(question.getQuestionId(), personId));
            question1.setBookmarked(discussDao.isQuestionBookmarkedByPerson(question.getQuestionId(), personId));
            return question1;
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeQuestion(int questionId, int personId) {
        return discussDao.likeQuestion(questionId, personId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean likeComment(int commentId, int personId) {
        return discussDao.likeComment(commentId, personId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean bookmarkQuestion(int questionId, int personId) {
        return discussDao.bookmarkQuestion(questionId, personId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Comment addComment(CommentAdditionRequest commentAdditionRequest) {

        if(discussDao.commentAlreadyExistsFor(commentAdditionRequest.getQuestionId(), commentAdditionRequest.getPersonId()))
            return null;

        com.discuss.core.dao.entity.Comment comment = discussDao.addComment(commentAdditionRequest);

        if(comment == null)
            return null;
        return ServiceDaoEntityMapper.commentMapper.apply(comment);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Category> getQuestionCategoriesForPerson(int personId) {
        return discussDao.getQuestionCategoriesForPerson(personId)
            .stream()
            .map(tag -> Tag.getCategoryForTag(tag).orElse(null))
            .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Category> getCategoryList() {
        List<Tag> tags = discussDao.getCategoryList();
        return CollectionUtils.isEmpty(tags) ? EMPTY_CATEGORY_LIST : tags.stream().map(ServiceDaoEntityMapper.categoryMapper).collect(Collectors.toList());
    }

    @Override
    public Question addQuestion(QuestionAdditionRequest questionAdditionRequest) {
        if(StringUtils.isNotBlank(questionAdditionRequest.getImage())) {
            String savedImagePath = imageStore.storeImage(questionAdditionRequest.getImage());
            questionAdditionRequest.setImage(savedImagePath);
        }

        com.discuss.core.dao.entity.Question question = discussDao.addQuestion(questionAdditionRequest);
        if(question == null)
            return null;
        return ServiceDaoEntityMapper.questionMapper.apply(question);
    }


}
