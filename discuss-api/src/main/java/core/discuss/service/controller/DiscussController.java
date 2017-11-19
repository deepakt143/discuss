package core.discuss.service.controller;

import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.Response;
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
    Response<List<Question>> getQuestions(@RequestParam(value = "sortBy") final String sortBy,
                                @RequestParam(value = "sortOrder") final String sortOrder,
                                @RequestParam(value = "offset") final Integer offset,
                                @RequestParam(value = "limit") final Integer limit,
                                @RequestParam(value = "personId") final Integer personId);

    @RequestMapping(method = RequestMethod.GET, value = {"/question/comments"})
    Response<List<Comment>> getCommentsForQuestion(@RequestParam(value = "questionId") final Integer questionId,
                                         @RequestParam(value = "offset") final Integer offset,
                                         @RequestParam(value = "limit") final Integer limit,
                                         @RequestParam(value = "sortBy") final String sortBy,
                                         @RequestParam(value = "sortOrder") final String sortOrder,
                                         @RequestParam(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.GET, value = {"/person/bookmarked/questions"})
   Response<List<Question>> getBookMarkedQuestions(@RequestParam(value = "offset") final Integer offset,
                                          @RequestParam(value = "limit") final Integer limit,
                                          @RequestParam(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.GET, value = {"/person/liked/questions"})
   Response<List<Question>>getLikedQuestions(@RequestParam(value = "offset") final Integer offset,
                                          @RequestParam(value = "limit") final Integer limit,
                                          @RequestParam(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.GET, value = {"questions/commented"})
   Response<List<Question>> getQuestionsCommented(@RequestParam(value = "offset") final Integer offset,
                                     @RequestParam(value = "limit") final Integer limit,
                                     @RequestParam(value = "personId") final Integer personId);


   @RequestMapping(method = RequestMethod.GET, value = {"/question/user/comment"})
   Response<Comment> getPersonAddedCommentOnQuestion(@RequestParam(value = "questionId") final Integer questionId,
                                         @RequestHeader(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.GET, value = {"/question/info"})
   Response<Question> getQuestion(@RequestParam(value = "questionId") final Integer questionId,
                         @RequestHeader(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.POST, value = {"/question/upvote"})
   Response<Boolean> likeQuestion(@RequestParam(value = "questionId") final Integer questionId,
                           @RequestHeader(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.POST, value = {"/comment/upvote"})
   Response<Boolean> likeComment(@RequestParam(value = "commentId") final Integer commentId,
                          @RequestHeader(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.POST, value = {"/bookmark/question"})
   Response<Boolean> bookmarkQuestion(@RequestParam(value = "questionId") final Integer questionId,
                             @RequestHeader(value = "personId") final Integer personId);

   @RequestMapping(method = RequestMethod.POST,  value = {"/question/comment"})
   Response<Comment> addComment(CommentAdditionRequest commentAdditionRequest);

   @RequestMapping(method = RequestMethod.GET, value = {"/category/list"})
   Response<List<Category>> getCategoryList();

   @RequestMapping(method = RequestMethod.GET, value = {"/category/preference"})
   Response<List<Category>> getQuestionCategoriesForPerson(@RequestParam(value = "personId") final Integer personId);

}
