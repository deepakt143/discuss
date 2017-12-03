package com.discuss.datatypes.request;

import lombok.Data;

/**
 *
 * @author Deepak Thakur
 */
@Data
public class QuestionAdditionRequest {
    private Integer personID;
    private String text;
    private String image;
    private String category;
    private Integer difficulty;

    public QuestionAdditionRequest() {
    }
}
