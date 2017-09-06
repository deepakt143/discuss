package com.discuss.core.service.impl;


import com.discuss.core.ServiceDaoEntityMapper;
import com.discuss.core.Utils;
import com.discuss.core.dao.DiscussDao;
import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscussServiceImpl implements DiscussService {

    private final DiscussDao discussDao;

    @Autowired
    public DiscussServiceImpl(DiscussDao discussDao) {
        this.discussDao = discussDao;
    }
    
    @Override
    public List<Question> getQuestions(int category, int offset, int limit, String userId) {
        return Utils.emptyIfNullList(discussDao.getQuestions(category, offset, limit, userId)).
            stream().
            map(ServiceDaoEntityMapper.questionMapper).
            collect(Collectors.toList());
    }

    @Override
    public List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId) {
        return Utils.emptyIfNullList(discussDao.getCommentsForQuestion(questionId, offset, limit, userId)).
            stream().
            map(ServiceDaoEntityMapper.commentMapper).
            collect(Collectors.toList());
    }

    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, String userId) {
        return Utils.emptyIfNullList(discussDao.getBookMarkedQuestions(offset, limit, userId)).
            stream().
            map(ServiceDaoEntityMapper.questionMapper).
            collect(Collectors.toList());
    }

    @Override
    public List<Comment> getUserAddedComments(int offset, int limit, String userId) {
        return Utils.emptyIfNullList(discussDao.getUserAddedComments(offset, limit, userId)).
            stream().
            map(ServiceDaoEntityMapper.commentMapper).
            collect(Collectors.toList());
    }

    @Override
    public Question getQuestion(String questionId, String userId) {
        com.discuss.core.dao.entity.Question question = discussDao.getQuestion(questionId, userId);
        if(null != question) {
            return ServiceDaoEntityMapper.questionMapper.apply(question);
        }
        return null;
    }

    @Override
    public boolean likeQuestion(String questionId, String userId) {
        return discussDao.likeQuestion(questionId, userId);
    }

    @Override
    public boolean likeComment(String commentId, String userId) {
        return discussDao.likeComment(commentId, userId);
    }

    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        return discussDao.bookmarkQuestion(questionId, userId);
    }
}
