package com.mzy.leetcode;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.*;

//idea: 使用SET来维护不重复字符数组
//使用maxlength来维护最大数组长度
//使用指针来维护需要移动的下标
public class lt3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();

        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int cursor = 0;

        for (int i = 0; i < s.toCharArray().length; i++) {
            char chartemp = s.charAt(i);

            if (!map.containsKey(chartemp)) {

                map.put(chartemp, i);

            } else {
                //如果存在，则更新游标
                cursor = map.get(chartemp) + 1;

                //更新map集合,小于该索引的内容需要全部删除
                //使用迭代器
                Iterator iter = map.keySet().iterator();
                int indexdel = map.get(chartemp);
                while (iter.hasNext()) {
                    char key = (Character) iter.next();
                    if (map.get(key) <= indexdel) {
                        //删除
                        iter.remove();
                    }
                }
                map.put(chartemp, i);

            }
            //不论什么操作，总是维该变量
            maxLength = maxLength > i - cursor + 1 ? maxLength : i - cursor + 1;

        }
        return maxLength;


    }

    //使用dp来维护每一步的最大长度
    public static int lengthOfLongestSubstringDp(String s) {
        int maxlength = 0;
        if (s.length() <= 1) {
            return s.length();

        }
        int[] dp = new int[s.length()];
        int cursor = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {

            //判断每个字符在[cursor，i中是否存在
            int indexRepeat = s.substring(cursor, i).indexOf(s.charAt(i));
            if (indexRepeat != -1) {
                //存在相同字符
                cursor = cursor+indexRepeat + 1;
            }
            dp[i] = i - cursor + 1;
            maxlength = Math.max(dp[i], maxlength);


        }
        return maxlength;


    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringDp("bbbbb"));


    }


}
