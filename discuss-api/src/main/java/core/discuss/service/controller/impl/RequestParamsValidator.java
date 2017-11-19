package core.discuss.service.controller.impl;

import com.discuss.datatypes.SortBy;
import com.discuss.datatypes.SortOrder;
import com.discuss.datatypes.error.ErrorCode;
import com.discuss.datatypes.error.ErrorCodeConstants;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Deepak Thakur
 */
public class RequestParamsValidator {

    private static final List<ErrorCode> EMPTY_LIST = ImmutableList.of();

    static List<ErrorCode> validateOffset(final Integer offset) {
        if (null == offset  || offset < 0)
            return ErrorCodeConstants.INVALID_OFFSET_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateLimit(final Integer limit) {
        if (null == limit || limit < 0)
            return ErrorCodeConstants.INVALID_LIMIT_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateSortBy(final String sortBy) {
        Optional<SortBy> sortBy1 = SortBy.findByName(sortBy);

        if (!sortBy1.isPresent())
            return ErrorCodeConstants.INVALID_SORT_BY_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateSortOrder(final String sortOrder) {
        Optional<SortOrder> sortOrder1 = SortOrder.findByName(sortOrder);

        if (!sortOrder1.isPresent())
            return ErrorCodeConstants.INVALID_SORT_ORDER_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validatePersonID(final Integer personID) {
        if (null == personID || personID <= 0)
            return ErrorCodeConstants.INVALID_PERSON_ID_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateQuestionID(final Integer questionID) {
        if (null == questionID || questionID <= 0)
            return ErrorCodeConstants.INVALID_QUESTION_ID_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateCommentID(final Integer commentID) {
        if (null == commentID || commentID <= 0)
            return ErrorCodeConstants.INVALID_COMMENT_ID_ERROR;

        return EMPTY_LIST;
    }

    static List<ErrorCode> validateSorting(final String sortBy, final String sortOrder) {
        List<ErrorCode> errorCodes = Lists.newArrayList();
        errorCodes.addAll(validateSortBy(sortBy));
        errorCodes.addAll(validateSortOrder(sortOrder));
        return errorCodes;
    }

    static List<ErrorCode> validateLimits(final Integer offset, final Integer limit) {
        List<ErrorCode> errorCodes = Lists.newArrayList();
        errorCodes.addAll(validateOffset(offset));
        errorCodes.addAll(validateLimit(limit));
        return errorCodes;
    }
}