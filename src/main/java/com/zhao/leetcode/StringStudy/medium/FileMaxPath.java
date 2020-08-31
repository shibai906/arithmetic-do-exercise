package com.zhao.leetcode.StringStudy.medium;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-30 17:02
 * @description 地址：https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 题目：文件的最长绝对路径
 * 描述：假设我们以下述方式将我们的文件系统抽象成一个字符串:
 * 字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
 * dir
 * subdir1
 * subdir2
 * file.ext
 * 目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 * 目录 dir 包含两个子目录 subdir1 和 subdir2。 subdir1 包含一个文件 file1.ext 和一个空的二级子目录 subsubdir1。
 * subdir2 包含一个二级子目录 subsubdir2 ，其中包含一个文件 file2.ext。
 * <p>
 * 我们致力于寻找我们文件系统中文件的最长 (按字符的数量统计) 绝对路径。
 * 例如，在上述的第二个例子中，最长路径为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 (不包含双引号)。
 * <p>
 * 给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
 **/
public class FileMaxPath {

    public static void main(String[] args) {
        FileMaxPath fmp = new FileMaxPath();
        System.out.println(fmp.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println("dir/subdir2/subsubdir2/file2.ext".length());

        System.out.println("\t\t\t".length());
        System.out.println("\t\t\t".lastIndexOf("\t"));
    }

    public int toUser(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        // 以 \n 分割成字符串数组
        String[] str = input.split("\n");
        // dir,\tsubdir1,\tsubdir2,\tfile.ext
        for (String s : str) {
            // level 代表当前字符串的首字母索引
            // 字符串前面可能会有多个 \t,故使用 lastIndexOf 找出最后一个 \t 位置即可
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            // 之前入栈的字符串 + 当前遍历到的字符串的长度
            int len = stack.peek() + (s.length() - level + 1);
            stack.push(len);
            if (s.contains(".")) {
                ans = Math.max(ans, len - 1);
            }
        }
        return ans;
    }

    /**
     * 需要考虑错误的情况，如果是错误的，如果没有文件，直接返回0即可。如果有问题，格式不正确，直接返回文件的长度即可
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] strs = input.split("\n");
        int result = 1;
        for (String str : strs) {
            int peek = str.lastIndexOf("\t") + 1;
            while (peek + 1 < stack.size()) {
                stack.pop();
            }
            int ans = stack.peek() + str.length() - peek + 1;
            stack.push(ans);
            if (str.contains(".")) {
                result = Math.max(result, ans);
            }
        }
        return result;
    }




}
