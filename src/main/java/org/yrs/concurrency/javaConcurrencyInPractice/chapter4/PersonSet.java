package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangrusheng
 * @Description: 通过封闭机制来确保线程安全
 * @Date: Created in 19:26 2018/9/13
 * @Modified By:
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containPerson(Person p) {
        return mySet.contains(p);
    }
}
