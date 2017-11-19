package com.discuss.core.dao;

import com.discuss.core.dao.entity.Comment;
import com.discuss.core.dao.entity.Person;
import com.discuss.core.dao.entity.Question;
import com.discuss.core.dao.entity.Tag;
import com.discuss.datatypes.request.CommentAdditionRequest;

import java.util.List;

public interface DiscussDao {
    List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, List<Integer> tagIds);

    List<Comment> getCommentsForQuestion(int questionId, int offset, int limit);

    List<Question> getBookMarkedQuestions(int offset, int limit, int personId);

    List<Question> getLikedQuestions(int offset, int limit, int personId);

    List<Question> getQuestionsCommented(int offset, int limit, int personId);

    Question getQuestion(int questionId);

    boolean likeQuestion(int questionId, int personId);

    boolean likeComment(int commentId, int personId);

    boolean bookmarkQuestion(int questionId, int personId);

    Comment addComment(CommentAdditionRequest commentAdditionRequest);

    boolean commentAlreadyExistsFor(int questionId, int personId);

    List<Tag> getQuestionCategoriesForPerson(int personId);

    boolean isQuestionLikedByPerson(int questionId, int personId);

    boolean isQuestionBookmarkedByPerson(int questionId, int personId);

    boolean isCommentLikedByPerson(int commentId, int personId);

    Comment getPersonAddedCommentOnQuestion(int questionId, int personId);

    List<Tag> getCategoryList();

    Person getPerson(int personId);

}
