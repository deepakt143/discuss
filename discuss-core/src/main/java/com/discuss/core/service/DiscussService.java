package com.discuss.core.service;


import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;

import java.util.List;

public interface DiscussService {

    List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, int personId);

    List<Comment> getCommentsForQuestion(int questionId, String sortBy, String sortOrder, int offset, int limit, int personId);

    List<Question> getBookMarkedQuestions(int offset, int limit, int personId);

    List<Question> getLikedQuestions(int offset, int limit, int personId);

    List<Question> getQuestionsCommented(int offset, int limit, int personId);

    Comment getPersonAddedCommentOnQuestion(int questionId, int personId);

    Question getQuestion(int questionId, int personId);

    boolean likeQuestion(String questionId, String personId);

    boolean likeComment(String questionId, String personId);

    boolean bookmarkQuestion(String questionId, String personId);

    List<Category> getQuestionCategoriesForPerson(int personId);
}
