package com.discuss.datatypes;


import java.io.Serializable;

/**
 *
 * @author Deepak Thakur
 */
public class UserCategoryPreference implements Serializable {
    private final Category category;
    private final boolean preferred;

    public UserCategoryPreference(final Category category, final boolean preferred) {
        this.category = category;
        this.preferred = preferred;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getPreferred() {
        return preferred;
    }

}
