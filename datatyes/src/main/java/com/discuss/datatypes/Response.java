package com.discuss.datatypes;

import com.discuss.datatypes.error.ErrorCode;

import java.util.List;

/**
 * @author Deepak Thakur
 */
public class Response<T> {
    private T data;
    private List<ErrorCode> errorCodes;
    private boolean success;

    public Response(T data, List<ErrorCode> errorCodes, boolean success) {
        this.data = data;
        this.errorCodes = errorCodes;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public List<ErrorCode> getErrorCodes() {
        return errorCodes;
    }

    public boolean getSuccess() {
        return success;
    }

    public static <U> Response<U> successfulResponse(U data) {
        return new Response<>(data, null, true);
    }

    public static <U> Response<U> unSuccessfulResponse(List<ErrorCode> errorCodes) {
        return new Response<>(null, errorCodes, false);
    }
}
