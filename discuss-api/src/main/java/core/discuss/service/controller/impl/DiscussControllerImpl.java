package core.discuss.service.controller.impl;


import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.request.CommentAdditionRequest;
import core.discuss.service.controller.DiscussController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 *
 * @author Deepak Thakur
 */
@Controller
public class DiscussControllerImpl implements DiscussController {

    private final DiscussService discussService;
    @Autowired
    public DiscussControllerImpl(DiscussService discussService) {
        this.discussService = discussService;
    }

    @Override
    public List<Question> getQuestions(String sortBy, String sortOrder, int offset, int limit, int personId) {
        return discussService.getQuestions(sortBy, sortOrder, offset, limit, personId);
    }

    @Override
    public List<Comment> getCommentsForQuestion(int questionId, int offset, int limit, String sortBy, String sortOrder, int personId) {
        return discussService.getCommentsForQuestion(questionId, sortBy, sortOrder, offset, limit, personId);
    }

    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, int personId) {
        return discussService.getBookMarkedQuestions(offset, limit, personId);
    }

    @Override
    public List<Question> getLikedQuestions(int offset, int limit, int personId) {
        return discussService.getLikedQuestions(offset, limit, personId);
    }

    @Override
    public List<Question> getQuestionsCommented(int offset, int limit, int personId) {
        return discussService.getQuestionsCommented(offset, limit, personId);
    }

    @Override
    public Comment getPersonAddedCommentOnQuestion(int questionId, int personId) {
        return discussService.getPersonAddedCommentOnQuestion(questionId, personId);
    }

    @Override
    public Question getQuestion(int questionId, int personId) {
        return discussService.getQuestion(questionId, personId);
    }

    @Override
    public boolean likeQuestion(int questionId, int personId) {
        return discussService.likeQuestion(questionId, personId);
    }

    @Override
    public boolean likeComment(int commentId, int personId) {
        return discussService.likeComment(commentId, personId);
    }

    @Override
    public boolean bookmarkQuestion(int questionId, int personId) {
        return discussService.bookmarkQuestion(questionId, personId);
    }

    @Override
    public Comment addComment(CommentAdditionRequest commentAdditionRequest) {
        return discussService.addComment(commentAdditionRequest);
    }

    @Override
    public List<Category> getCategoryList() {
        return discussService.getCategoryList();
    }

    @Override
    public List<Category> getQuestionCategoriesForPerson(int personId) {
        return discussService.getQuestionCategoriesForPerson(personId);
    }

    @Override
    public boolean getQuestionCategoriesForPerson() {
        return true;
    }


}
