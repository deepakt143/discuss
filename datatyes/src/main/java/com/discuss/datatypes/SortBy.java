package com.discuss.datatypes;

import com.google.common.collect.ImmutableMap;

import java.util.Optional;

/**
 *
 * @author Deepak Thakur
 */
public enum SortBy {
    LIKES("likes"),
    VIEWS("views"),
    MODIFIED_ON("modified_on"),
    CREATED_ON("created_on");

    private static final ImmutableMap<String, Optional<SortBy>> nameToSortByMap;

    static {
        ImmutableMap.Builder<String, Optional<SortBy>> builder = ImmutableMap.builder();
        for (SortBy sortBy : SortBy.values()) {
            builder.put(sortBy.getName(), Optional.of(sortBy));
        }
        nameToSortByMap = builder.build();
    }

    final String name;

    public String getName() {
        return name;
    }

    SortBy(final String name) {
        this.name = name;
    }

    public static Optional<SortBy> findByName(final String name) {
        if(name == null)
            return Optional.empty();
        return nameToSortByMap.getOrDefault(name, Optional.<SortBy>empty());
    }
}
