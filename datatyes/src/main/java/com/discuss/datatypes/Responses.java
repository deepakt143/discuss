package com.discuss.datatypes;

import com.discuss.datatypes.Response;
import com.discuss.datatypes.error.ErrorCode;

import java.util.Collections;

/**
 *
 * @author Deepak Thakur
 */
public class Responses {
    public static final Response<Void> RESPONSE_SORT_BY_ABSENT = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_SORT_BY), false);
    public static final Response<Void> RESPONSE_SORT_ORDER_ABSENT = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_SORT_ORDER), false);
    public static final Response<Void> RESPONSE_INVALID_OFFSET = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_OFFSET), false);
    public static final Response<Void> RESPONSE_INVALID_LIMIT = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_LIMIT), false);
    public static final Response<Void> RESPONSE_INVALID_PERSON_ID = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_PERSON_ID), false);
    public static final Response<Void> RESPONSE_INVALID_QUESTION_ID = new Response<>(null, Collections.singletonList(ErrorCode.INVALID_QUESTION_ID), false);
    public static final Response<Void> RESPONSE_EMPTY = new Response<>(null, null, true);
}
