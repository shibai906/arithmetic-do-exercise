package com.zhao.enums;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-07-13 15:41
 * @description
 **/
public enum TestEnum {

    ;
    int value;

    private TestEnum(int value) {
        this.value = value;
    }

    public static TestEnum getInstance(int value) {
        for (TestEnum testEnum : TestEnum.values()) {
            if (testEnum.value == value) {
                return testEnum;
            }
        }
        return null;
    }

    public static TestEnum getValue(int value) {
        return Stream.of(TestEnum.values()).filter(e -> e.value == value).findFirst().orElse(null);
    }


}
