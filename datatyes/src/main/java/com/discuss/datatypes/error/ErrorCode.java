package com.discuss.datatypes.error;

/**
 *
 * @author Deepak Thakur
 */
public enum  ErrorCode {

    INVALID_SORT_BY(1, "Invalid sortBy"),
    INVALID_SORT_ORDER(2, "Invalid sortOrder"),
    INVALID_OFFSET(3, "Invalid offset"),
    INVALID_LIMIT(4, "Invalid limit"),
    INVALID_PERSON_ID(5, "Invalid personId"),
    INVALID_QUESTION_ID(6, "Invalid questionId"),
    INVALID_COMMENT_ID(7, "Invalid commentId");

    private final int errorCode;
    private final String errorMsg;
    ErrorCode(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


}
