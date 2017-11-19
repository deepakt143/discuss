package com.discuss.datatypes.error;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Deepak Thakur
 */
public class ErrorCodeConstants {
    public static final List<ErrorCode> INVALID_OFFSET_ERROR = ImmutableList.of(ErrorCode.INVALID_OFFSET);
    public static final List<ErrorCode> INVALID_LIMIT_ERROR = ImmutableList.of(ErrorCode.INVALID_LIMIT);
    public static final List<ErrorCode> INVALID_SORT_BY_ERROR = ImmutableList.of(ErrorCode.INVALID_SORT_BY);
    public static final List<ErrorCode> INVALID_SORT_ORDER_ERROR = ImmutableList.of(ErrorCode.INVALID_SORT_ORDER);
    public static final List<ErrorCode> INVALID_PERSON_ID_ERROR = ImmutableList.of(ErrorCode.INVALID_PERSON_ID);
    public static final List<ErrorCode> INVALID_QUESTION_ID_ERROR = ImmutableList.of(ErrorCode.INVALID_QUESTION_ID);
    public static final List<ErrorCode> INVALID_COMMENT_ID_ERROR = ImmutableList.of(ErrorCode.INVALID_COMMENT_ID);

}
