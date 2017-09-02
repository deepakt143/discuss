package core.discuss.service.controller.impl;


import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import core.discuss.service.controller.DiscussController;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DiscussControllerImpl implements DiscussController {
    @Override
    public List<Question> getQuestions(String category, int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Comment> getCommentsForQuestion(String questionId, int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Question> getBookMarkedQuestions(int offset, int limit, String userId) {
        return null;
    }

    @Override
    public List<Comment> getUserAddedComments(int offset, int limit, String userId) {
        return null;
    }

    @Override
    public Question getQuestion(String questionId, String userId) {
        return null;
    }

    @Override
    public boolean upvoteQuestion(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean downvoteQuestion(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean upvoteComment(String questionId, String userId) {
        return false;
    }

    @Override
    public boolean downvoteComment(String commentId, String userId) {
        return false;
    }

    @Override
    public boolean bookmarkQuestion(String questionId, String userId) {
        return false;
    }
}
