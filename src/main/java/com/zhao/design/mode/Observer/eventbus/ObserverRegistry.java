package com.zhao.design.mode.Observer.eventbus;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-10-12 17:40
 * @description Observer 注册表，所有复杂的逻辑都在这，大量使用了 Java 的反射语法
 * 最巧妙的是： CopyOnWriteArraySet的使用，CopyOnWriteArraySet，顾名思义，在写入数据的时候，会创建一个新的 set，并且将原
 * 始数据 clone 到新的 set 中，在新的 set 中写入数据完成之后，再用新的 set 替换老的
 * set。这样就能保证在写入数据的时候，不影响数据的读取操作，以此来解决读写并发问题。
 * CopyOnWriteSet 还通过加锁的方式，避免了并发写冲突。
 **/
public class ObserverRegistry {

}

