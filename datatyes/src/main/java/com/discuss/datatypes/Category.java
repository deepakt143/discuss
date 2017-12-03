package com.discuss.datatypes;


import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Optional;

/* @todo(deepak): need to get directly from persistence store instead of mapping  */
public enum Category {
    PHYSICS("PHYSICS"),
    CHEMISTRY("CHEMISTRY"),
    MATHEMATICS("MATHEMATICS"),
    GRE("GRE"),
    GMAT("GMAT"),
    CAT("CAT"),
    IIT("IIT");

    private static final ImmutableMap<String, Optional<Category>> nameToCategoryMap;

    static {
        ImmutableMap.Builder<String, Optional<Category>> builder = ImmutableMap.builder();
        for (Category category : Category.values()) {
            builder.put(category.getName(), Optional.<Category>of(category));
        }
        nameToCategoryMap = builder.build();
    }

    private final String name;

    public String getName() {
        return name;
    }
    Category(String name) {
        this.name = name;
    }
    public static Optional<Category> findByName(final String name) {
        if(name == null)
            return Optional.empty();
        return nameToCategoryMap.getOrDefault(name, Optional.<Category>empty());
    }
}
