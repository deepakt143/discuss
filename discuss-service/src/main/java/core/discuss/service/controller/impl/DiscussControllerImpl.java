package core.discuss.service.controller.impl;


import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import core.discuss.service.controller.DiscussController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DiscussControllerImpl implements DiscussController {

    private final DiscussService discussService;
    @Autowired
    public DiscussControllerImpl(DiscussService discussService) {
        this.discussService = discussService;
    }
    @Override
    public List<Question> getQuestions(int category, int offset, int limit, String userId) {
        return discussService.getQuestions(category, offset, limit, userId);
    }

    @Override
    public List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId) {
        return discussService.getCommentsForQuestion(questionId, offset, limit, userId);
    }

    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, String userId) {
        return discussService.getBookMarkedQuestions(offset, limit, userId);
    }

    @Override
    public List<Comment> getUserAddedComments(int offset, int limit, String userId) {
        return discussService.getUserAddedComments(offset, limit, userId);
    }

    @Override
    public Question getQuestion(String questionId, String userId) {
        return discussService.getQuestion(questionId, userId);
    }

    @Override
    public boolean likeQuestion(String questionId, String userId) {
        return discussService.likeQuestion(questionId, userId);
    }

    @Override
    public boolean likeComment(String questionId, String userId) {
        return discussService.likeComment(questionId, userId);
    }

    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        return discussService.bookmarkQuestion(questionId, userId);
    }
}
