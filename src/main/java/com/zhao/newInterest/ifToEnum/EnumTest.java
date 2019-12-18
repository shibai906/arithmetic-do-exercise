package com.zhao.newInterest.ifToEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-18
 * @Time: 下午5:22
 * @Description:
 */
public enum EnumTest {
/*
    else if (name == "liuer") {
        return "qianreng" ;
    } else if (name == "zhaojiaxing") {
        return "qianreng" ;
    } else if (name == "dingyao") {
        return "chadian" ;
    } else if (name == "jiajiaojiao") {
        return "weiyi" ;
    } else if (name == "zhengyan") {
        return "chadian" ;
    } else if (name == "jiakaidi") {
        return "chadian" ;
    } else if (name == "liuyao") {
        return "chadian" ;
    } else if (name == "shiyu") {
        return "buyaole" ;
    } else if (name == "tingting") {
        return "chadian" ;
    }
        return null;

 */

    ZHAOHUAN("zhaohuan") {
        @Override
        public String handle(String userID) {
            System.out.println(userID);
            return "benren";
        }
    },
    LIUER("liuer") {
        @Override
        public String handle(String userID) {
            System.out.println(userID);
            return "qianreng";
        }
    },
    ZHAOJIAXXING("zhaojiaxing") {
        @Override
        public String handle(String userID) {
            System.out.println(userID);
            return "qianreng";
        }
    },
    ;
    private String name ;

    EnumTest(String name) {
        this.name = name;
    }

    public static EnumTest getByName(String name) {
        for(EnumTest enumTest : EnumTest.values()) {
            if(enumTest.name.equals(name)) {
                return enumTest;
            }
        }
        return null;
    }

    public abstract String handle(String userID);




}
