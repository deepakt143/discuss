package com.discuss.datatypes.request;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Deepak Thakur
 */
@Data
public class CommentAdditionRequest implements Serializable {
    private Integer questionId;
    private Integer personId;
    private String text;

    public CommentAdditionRequest() { /** spring framework needs a default constructor  **/
    }
}
