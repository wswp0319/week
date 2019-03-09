package com.wp.week.mapper;

import java.util.List;
import java.util.Map;

public interface IBase<T> {
    int add(T var1);

    int edit(T var1);

    int del(T var1);

    List<T> list(Map var1);

    int count(Map var1);

    T selInfo(Map var1);

//    PageList<T> queryPage(Map var1, PageBounds var2);
}
