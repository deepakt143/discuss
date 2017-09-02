package com.discuss.core.service.impl;


import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService{
    @Override
    public List<Question> getQuestions(String category, int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Comment> getUserAddedComments(int offset, int limit, String userId) {
        return null;
    }

    @Override
    public Question getQuestion(String questionId, String userId) {
        return null;
    }

    @Override
    public boolean upvoteQuestion(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean downvoteQuestion(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean upvoteComment(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean downvoteComment(String commentId, String userId) {
        return false;
    }

    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        return false;
    }
}
