package core.discuss.service.controller;

import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.request.CommentAdditionRequest;
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


    @RequestMapping(method = RequestMethod.GET, value = {"/question/user/comment"})
    Comment getPersonAddedCommentOnQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                                         @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/info"})
    Question getQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                         @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.POST, value = {"/question/upvote"})
    boolean likeQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                           @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.POST, value = {"/comment/upvote"})
    boolean likeComment(@RequestParam(value = "commentId", required = true) final int commentId,
                          @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.POST, value = {"/bookmark/question"})
    boolean bookmarkQuestion(@RequestParam(value = "questionId", required = true) final int questionId,
                             @RequestHeader(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces="application/json", value = {"/question/comment"})
    Comment addComment(@RequestBody CommentAdditionRequest commentAdditionRequest);

    @RequestMapping(method = RequestMethod.GET, value = {"/category/list"})
    List<Category> getCategoryList();

    @RequestMapping(method = RequestMethod.GET, value = {"/category/preference"})
    List<Category> getQuestionCategoriesForPerson(@RequestParam(value = "personId", required = true) final int personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/test1"})
    boolean getQuestionCategoriesForPerson();


}
