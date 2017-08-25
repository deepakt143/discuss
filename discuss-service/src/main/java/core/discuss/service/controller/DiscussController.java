package core.discuss.service.controller;

import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Deepak Thakur
 */
@Controller
@RequestMapping("/discuss")
@ResponseBody
public class DiscussController {

    @RequestMapping(method = RequestMethod.GET, value = {"/questions/list"})
    public List<Question> getQuestions(@RequestParam(value = "category", required = true) final String category,
                                          @RequestParam(value = "offset", required = true) final int offset,
                                          @RequestParam(value = "limit", required = true) final int limit,
                                          @RequestHeader(value = "userId", required = true) final String userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/question/comments"})
    public List<Comment> getCommentsForQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                     @RequestParam(value = "offset", required = true) final int offset,
                                     @RequestParam(value = "limit", required = true) final int limit,
                                     @RequestHeader(value = "userId", required = true) final String userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/user/bookmarked/questions"})
    public List<Question> getBookMarkedQuestions(@RequestParam(value = "offset", required = true) final int offset,
                                     @RequestParam(value = "limit", required = true) final int limit,
                                     @RequestHeader(value = "userId", required = true) final String userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/user/comments"})
    public List<Comment> getUserAddedComments(@RequestParam(value = "offset", required = true) final int offset,
                                                 @RequestParam(value = "limit", required = true) final int limit,
                                                 @RequestHeader(value = "userId", required = true) final String userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/question/info"})
    public Question getQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                      @RequestHeader(value = "userId", required = true) final String userId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/question/upvote"})
    public boolean upvoteQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                  @RequestHeader(value = "userId", required = true) final String userId) {
        return false;

    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/question/downvote"})
    public boolean downvoteQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                  @RequestHeader(value = "userId", required = true) final String userId) {
        return false;

    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/comment/upvote"})
    public boolean upvoteComment(@RequestParam(value = "questionId", required = true) final String questionId,
                                  @RequestHeader(value = "userId", required = true) final String userId) {
        return false;

    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/comment/downvote"})
    public boolean downvoteComment(@RequestParam(value = "commentId", required = true) final String commentId,
                                    @RequestHeader(value = "userId", required = true) final String userId) {
        return false;

    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/bookmark/question"})
    public boolean bookmarkQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                   @RequestHeader(value = "userId", required = true) final String userId) {
        return false;

    }


}
