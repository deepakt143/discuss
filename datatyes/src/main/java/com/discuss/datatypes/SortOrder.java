package com.discuss.datatypes;

import com.google.common.collect.ImmutableMap;

import java.util.Optional;

/**
 *
 * @author Deepak Thakur
 */
public enum  SortOrder {
    ASC("asc"),
    DESC("desc");

    private static final ImmutableMap<String, Optional<SortOrder>> nameToSortByMap;

    static {
        ImmutableMap.Builder<String, Optional<SortOrder>> builder = ImmutableMap.builder();
        for (SortOrder sortOrder : SortOrder.values()) {
            builder.put(sortOrder.getName(), Optional.of(sortOrder));
        }
        nameToSortByMap = builder.build();
    }

    final String name;

    public String getName() {
        return name;
    }

    SortOrder(final String name) {
        this.name = name;
    }

    public static Optional<SortOrder> findByName(final String name) {
        if(name == null)
            return Optional.empty();
        return nameToSortByMap.getOrDefault(name, Optional.<SortOrder>empty());
    }
}
