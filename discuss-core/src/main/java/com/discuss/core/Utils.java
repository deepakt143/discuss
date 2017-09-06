package com.discuss.core;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * @author Deepak Thakur
 */
public class Utils {

    public static <T> List<T> emptyIfNullList(List<T> list) {
        if(null == list)
            return Lists.newArrayList();
        return list;
    }
}
