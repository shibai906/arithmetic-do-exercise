package com.zhao.leetcode;

/**
 * 还未解出来，等着解决
 * Dota2参议院，
 * 题目是这样的，有两方阵营，那方阵营在前有优势，一定静止另一方；如下：
 * 输入: "RD"
 * 输出: "Radiant"
 * 解释:  第一个参议员来自  Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的
 * <p>
 * 输入: "RDD"
 * 输出: "Dire"
 * 解释:
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 */
public class Dota2Senate {

    public static void main(String[] args) {
        predictPartyVictory("DDRRR");
    }

    public static String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                if(r == 0 || d == 0) {
                    r += 2;
                    d -- ;
                }else if (d >= 0){
                    r ++;
                    d--;
                } else {
                    r ++;
                }
            }
            if (senate.charAt(i) == 'D') {
                if (r == 0 || d == 0) {
                    d += 2;
                    r--;
                } else if (d >= 0){
                    d ++;
                    r--;
                }else {
                    d ++;
                }
            }
        }
        if (r > d) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

}
