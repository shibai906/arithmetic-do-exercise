package com.zhao.design.mode.component.safety;

import com.zhao.design.mode.component.safety.MobileComponent;

/**
 * @program: 树叶手机构建角色类
 * @author zhaohuan
 * @time 2019-8-22 21:23
 */
public class SpecifyMobile implements MobileComponent {

    private String name ;

    public SpecifyMobile(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String pre) {
        System.out.printf(pre + "----" + this.name);
    }
}
