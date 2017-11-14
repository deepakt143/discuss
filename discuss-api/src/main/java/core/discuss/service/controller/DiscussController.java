package core.discuss.service.controller;

import com.discuss.datatypes.Category;
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
    List<Question> getQuestions(@RequestParam(value = "sortBy", required = true) final String sortBy,
                                @RequestParam(value = "sortOrder", required = true) final String sortOrder,
                                @RequestParam(value = "offset", required = true) final int offset,
                                @RequestParam(value = "limit", required = true) final int limit,
                                @RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/comments"})
    List<Comment> getCommentsForQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                                         @RequestParam(value = "offset", required = true) final int offset,
                                         @RequestParam(value = "limit", required = true) final int limit,
                                         @RequestParam(value = "sortBy", required = true) final String sortBy,
                                         @RequestParam(value = "sortOrder", required = true) final String sortOrder,
                                         @RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/person/bookmarked/questions"})
    List<Question> getBookMarkedQuestions(@RequestParam(value = "offset", required = true) final int offset,
                                          @RequestParam(value = "limit", required = true) final int limit,
                                          @RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/person/liked/questions"})
    List<Question> getLikedQuestions(@RequestParam(value = "offset", required = true) final int offset,
                                          @RequestParam(value = "limit", required = true) final int limit,
                                          @RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"questions/commented"})
    List<Question> getQuestionsCommented(@RequestParam(value = "offset", required = true) final int offset,
                                     @RequestParam(value = "limit", required = true) final int limit,
                                     @RequestParam(value = "personId", required = true) final int personId);


    @RequestMapping(method = RequestMethod.GET, value = {"question/user/comment"})
    Comment getPersonAddedCommentOnQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                                         @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/info"})
    Question getQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                         @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/question/upvote"})
    boolean likeQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                           @RequestHeader(value = "personId", required = true) final String personId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/comment/upvote"})
    boolean likeComment(@RequestParam(value = "questionId", required = true) final String questionId,
                          @RequestHeader(value = "personId", required = true) final String personId);

    @RequestMapping(method = RequestMethod.PUT, value = {"/bookmark/question"})
    boolean bookmarkQuestion(@RequestParam(value = "questionId", required = true) final String questionId,
                             @RequestHeader(value = "personId", required = true) final String personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/test"})
    List<Category> getQuestionCategoriesForPerson(@RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/test1"})
    boolean getQuestionCategoriesForPerson();


}
