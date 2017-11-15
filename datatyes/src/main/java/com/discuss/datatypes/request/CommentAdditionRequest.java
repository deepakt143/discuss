package com.discuss.datatypes.request;

/**
 *
 * @author Deepak Thakur
 */

public class CommentAdditionRequest {
    private int questionId;
    private int personId;
    private String text;

    public CommentAdditionRequest() { /** spring framework needs a default constructor  **/
    }

    public CommentAdditionRequest(int questionId, int personId, String text) {
        this.questionId = questionId;
        this.personId = personId;
        this.text = text;
    }


    public String toString() {
        return "{\"questionId\":" + this.questionId + ", \"personId\":" + this.personId + ", \"text\":" + this.text + "}";
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public int getPersonId() {
        return this.personId;
    }

    public String getText() {
        return this.text;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentAdditionRequest)) return false;
        final CommentAdditionRequest other = (CommentAdditionRequest) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.questionId != other.questionId) return false;
        if (this.personId != other.personId) return false;
        final Object this$text = this.text;
        final Object other$text = other.text;
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.questionId;
        result = result * PRIME + this.personId;
        final Object $text = this.text;
        result = result * PRIME + ($text == null ? 0 : $text.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommentAdditionRequest;
    }
}
