package com.discuss.datatypes;


import com.google.common.collect.ImmutableMap;
import lombok.Getter;
/* @todo(deepak): need to get directly from persistence store instead of mapping  */
public enum Category {
    PHYSICS("PHYSICS"),
    CHEMISTRY("CHEMISTRY"),
    MATHEMATICS("MATHEMATICS"),
    GRE("GRE"),
    GMAT("GMAT"),
    CAT("CAT"),
    IIT("IIT");

    private static final ImmutableMap<String, Category> nameToCategoryMap;

    static {
        ImmutableMap.Builder<String, Category> builder = ImmutableMap.builder();
        for (Category category : Category.values()) {
            builder.put(category.getName(), category);
        }
        nameToCategoryMap = builder.build();
    }

    @Getter
    private final String name;
    Category(String name) {
        this.name = name;
    }
    public static Category findByName(final String name) {
        if(name == null)
            return null;
        return nameToCategoryMap.get(name);
    }
}
