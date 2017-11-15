package com.discuss.core.service;


import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.request.CommentAdditionRequest;

import java.util.List;

public interface DiscussService {

    List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, int personId);

    List<Comment> getCommentsForQuestion(int questionId, String sortBy, String sortOrder, int offset, int limit, int personId);

    List<Question> getBookMarkedQuestions(int offset, int limit, int personId);

    List<Question> getLikedQuestions(int offset, int limit, int personId);

    List<Question> getQuestionsCommented(int offset, int limit, int personId);

    Comment getPersonAddedCommentOnQuestion(int questionId, int personId);

    Question getQuestion(int questionId, int personId);

    boolean likeQuestion(int questionId, int personId);

    boolean likeComment(int commentId, int personId);

    boolean bookmarkQuestion(int questionId, int personId);

    Comment addComment(CommentAdditionRequest commentAdditionRequest);

    List<Category> getQuestionCategoriesForPerson(int personId);

    List<Category> getCategoryList();

}
