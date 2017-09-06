package com.discuss.core.dao;



import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Question;

import java.util.List;

public interface DiscussDao {
    List<Question> getQuestions(int categoryId, int offset, int limit, String userId);

    List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId);

    List<Question> getBookMarkedQuestions(int offset, int limit, String userId);

    List<Comment> getUserAddedComments(int offset, int limit, String userId);


    Question getQuestion(String questionId, String userId);

    boolean likeQuestion(String questionId, String userId);

    boolean likeComment(String questionId, String userId);

    boolean bookmarkQuestion(String questionId, String userId);
}
