package org.yrs.concurrency.javaConcurrencyInPractice.chapter3;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangrusheng
 * @Description: 在可变对象基础上构建的不可变类
 * @Date: Created in 10:15 2018/8/8
 * @Modified By:
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
