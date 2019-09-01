package com.zhao.design.mode.component.safety;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: 树叶手机构建角色类
 * @author zhaohuan
 * @time 2019-8-22 21:23
 */
public class MobileComposite implements MobileComponent {

    private String name ;
    private List<MobileComponent> childComponents = new ArrayList<>();

    public MobileComposite(String name) {
        this.name = name;
    }

    public void addChild(MobileComponent child) {
        childComponents.add(child);
    }

    public void removeChild(MobileComponent child) {
        childComponents.remove(child);
    }

    public List<MobileComponent> getChilds() {
        return childComponents;
    }

    @Override
    public void printStruct(String pre) {
        System.out.println(pre + "+" + this.name);
        if (this.childComponents != null) {
            pre += "  ";
            for(MobileComponent mobileComponent : childComponents) {
                mobileComponent.printStruct(pre);
            }
        }
        System.out.println();
    }
}
