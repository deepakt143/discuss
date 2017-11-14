package com.discuss.core.dao;



import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Question;
import com.discuss.core.dao.entity.Tag;

import java.util.List;

public interface DiscussDao {
    List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, int personId, List<Integer> tagIds);

    List<Comment> getCommentsForQuestion(int questionId, int offset, int limit, int personId);

    List<Question> getBookMarkedQuestions(int offset, int limit, int personId);

    List<Question> getLikedQuestions(int offset, int limit, int personId);

    List<Question> getQuestionsCommented(int offset, int limit, int personId);

    Question getQuestion(int questionId, int personId);

    boolean likeQuestion(String questionId, String personId);

    boolean likeComment(String questionId, String personId);

    boolean bookmarkQuestion(String questionId, int personId);

    List<Tag> getQuestionCategoriesForPerson(int personId);

    boolean isQuestionLikedByPerson(int questionId, int personId);

    boolean isQuestionBookmarkedByPerson(int questionId, int personId);

    boolean isCommentLikedByPerson(int commentId, int personId);

    Comment getPersonAddedCommentOnQuestion(int questionId, int personId);
}
