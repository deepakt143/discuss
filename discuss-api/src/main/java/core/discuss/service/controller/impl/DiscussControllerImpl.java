package core.discuss.service.controller.impl;


import com.discuss.core.service.DiscussService;
import com.discuss.datatypes.Category;
import com.discuss.datatypes.Comment;
import com.discuss.datatypes.Question;
import com.discuss.datatypes.Response;
import com.discuss.datatypes.error.ErrorCode;
import com.discuss.datatypes.request.CommentAdditionRequest;
import com.google.common.collect.Lists;
import core.discuss.service.controller.DiscussController;
import org.apache.commons.collections.CollectionUtils;
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
    public Response<List<Question>> getQuestions(String sortBy, String sortOrder, Integer offset, Integer limit, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateSorting(sortBy, sortOrder));
        errorCodes.addAll(RequestParamsValidator.validateLimits(offset, limit));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }
        return Response.successfulResponse(discussService.getQuestions(sortBy, sortOrder, offset, limit, personId));
    }

    @Override
    public Response<List<Comment>> getCommentsForQuestion(Integer questionId, Integer offset, Integer limit, String sortBy, String sortOrder, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateSorting(sortBy, sortOrder));
        errorCodes.addAll(RequestParamsValidator.validateLimits(offset, limit));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));
        errorCodes.addAll(RequestParamsValidator.validateQuestionID(questionId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getCommentsForQuestion(questionId, sortBy, sortOrder, offset, limit, personId));
    }

    @Override
    public Response<List<Question>> getBookMarkedQuestions(Integer offset, Integer limit, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateLimits(offset, limit));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getBookMarkedQuestions(offset, limit, personId));
    }

    @Override
    public Response<List<Question>> getLikedQuestions(Integer offset, Integer limit, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateLimits(offset, limit));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getLikedQuestions(offset, limit, personId));
    }

    @Override
    public Response<List<Question>> getQuestionsCommented(Integer offset, Integer limit, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateLimits(offset, limit));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getQuestionsCommented(offset, limit, personId));
    }

    @Override
    public Response<Comment> getPersonAddedCommentOnQuestion(Integer questionId, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateQuestionID(questionId));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getPersonAddedCommentOnQuestion(questionId, personId));
    }

    @Override
    public Response<Question> getQuestion(Integer questionId, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateQuestionID(questionId));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.getQuestion(questionId, personId));
    }

    @Override
    public Response<Boolean> likeQuestion(Integer questionId, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateQuestionID(questionId));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.likeQuestion(questionId, personId));
    }

    @Override
    public Response<Boolean> likeComment(Integer commentId, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateCommentID(commentId));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.likeComment(commentId, personId));
    }

    @Override
    public Response<Boolean> bookmarkQuestion(Integer questionId, Integer personId) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateQuestionID(questionId));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(personId));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.bookmarkQuestion(questionId, personId));
    }

    @Override
    public Response<Comment> addComment(@RequestBody CommentAdditionRequest commentAdditionRequest) {
        final List<ErrorCode> errorCodes = Lists.newArrayList();

        errorCodes.addAll(RequestParamsValidator.validateQuestionID(commentAdditionRequest.getQuestionId()));
        errorCodes.addAll(RequestParamsValidator.validatePersonID(commentAdditionRequest.getPersonId()));

        if(CollectionUtils.isNotEmpty(errorCodes)) {
            return Response.unSuccessfulResponse(errorCodes);
        }

        return Response.successfulResponse(discussService.addComment(commentAdditionRequest));
    }

    @Override
    public Response<List<Category>> getCategoryList() {
        return Response.successfulResponse(discussService.getCategoryList());
    }

    @Override
    public Response<List<Category>> getQuestionCategoriesForPerson(Integer personId) {
        return Response.successfulResponse(discussService.getQuestionCategoriesForPerson(personId));
    }
}
