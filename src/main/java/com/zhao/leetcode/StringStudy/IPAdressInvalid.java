package com.zhao.leetcode.StringStudy;

/**
 * 题目难易程度： easy
 * 1108. IP地址无效化
 * 地址： https://leetcode-cn.com/problems/defanging-an-ip-address/
 * 题目： 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 */
public class IPAdressInvalid {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        String[] strings = address.split("\\.");
        return join(strings,"[.]",0,strings.length);

    }

    public static String join(String[] array , String separator , int startIndex , int endIndex) {
        if(array == null) {
            return null;
        } else {
            if(separator == null) {
                separator = "";
            }
            int noOfItems = endIndex - startIndex;
            if(noOfItems <= 0) {
                return "";
            } else {
                StringBuilder buf = new StringBuilder(noOfItems * 16);

                for(int i = startIndex ; i < endIndex ; i ++) {
                    if(i > startIndex) {
                        buf.append(separator);
                    }
                    if(array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }

}
