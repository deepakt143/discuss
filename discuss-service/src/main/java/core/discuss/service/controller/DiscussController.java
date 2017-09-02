package core.discuss.service.controller;

import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deepak Thakur
 */
@RequestMapping("/discuss")
@ResponseBody
public interface DiscussController {

    @RequestMapping(method = RequestMethod.GET, value = {"/questions/list"})
    List<Question> getQuestions(@RequestParam(value = "category", required = true) final String category,
                                @RequestParam(value = "offset", required = true) final int offset,
                                @RequestParam(value = "limit", required = true) final int limit,
                                @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/comments"})
    List<Comment> getCommentsForQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                                         @RequestParam(value = "offset", required = true) final int offset,
                                         @RequestParam(value = "limit", required = true) final int limit,
                                         @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.GET, value = {"/user/bookmarked/questions"})
    List<Question> getBookMarkedQuestions(@RequestParam(value = "offset", required = true) final int offset,
                                          @RequestParam(value = "limit", required = true) final int limit,
                                          @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.GET, value = {"/user/comments"})
    List<Comment> getUserAddedComments(@RequestParam(value = "offset", required = true) final int offset,
                                       @RequestParam(value = "limit", required = true) final int limit,
                                       @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/info"})
    Question getQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                         @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/question/upvote"})
    boolean upvoteQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                           @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/question/downvote"})
    boolean downvoteQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                             @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/comment/upvote"})
    boolean upvoteComment(@RequestParam(value = "questionId", required = true) final String questionId,
                          @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/comment/downvote"})
    boolean downvoteComment(@RequestParam(value = "commentId", required = true) final String commentId,
                            @RequestHeader(value = "userId", required = true) final String userId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/bookmark/question"})
    boolean bookmarkQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                             @RequestHeader(value = "userId", required = true) final String userId);

}
