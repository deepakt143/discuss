package com.discuss.core.dao;



import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Question;

import java.util.List;

public interface DiscussDao {
    List<Question> getQuestions(String category, int offset, int limit, String userId);

    List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId);

    List<Question> getBookMarkedQuestions(int offset, int limit, String userId);

    List<Comment> getUserAddedComments(int offset, int limit, String userId);


    Question getQuestion(String questionId, String userId);

    boolean upvoteQuestion(String questionId, String userId);

    boolean upvoteComment(String questionId, String userId);

    boolean bookmarkQuestion(String questionId, String userId);
}
