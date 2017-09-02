package com.discuss.core.service;


import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;

import java.util.List;

public interface DiscussService {

    List<Question> getQuestions(String category, int offset, int limit, String userId);

    List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId);

    List<Question> getBookMarkedQuestions(int offset, int limit, String userId);

    List<Comment> getUserAddedComments(int offset, int limit, String userId);


    Question getQuestion(String questionId, String userId);

    boolean upvoteQuestion(String questionId, String userId);

    boolean downvoteQuestion(String questionId, String userId);

    boolean upvoteComment(String questionId, String userId);

    boolean downvoteComment(String commentId, String userId);

    boolean bookmarkQuestion(String questionId, String userId);
}
