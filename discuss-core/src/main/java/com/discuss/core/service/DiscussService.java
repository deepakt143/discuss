package com.discuss.core.service;


import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;

import java.util.List;

public interface DiscussService {

    List<Question> getQuestions(int category, int offset, int limit, String userId);

    List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId);

    List<Question> getBookMarkedQuestions(int offset, int limit, String userId);

    List<Comment> getUserAddedComments(int offset, int limit, String userId);


    Question getQuestion(String questionId, String userId);

    boolean likeQuestion(String questionId, String userId);

    boolean likeComment(String questionId, String userId);

    boolean bookmarkQuestion(String questionId, String userId);
}
