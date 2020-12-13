package com.tiger.offer.arrayAndString;

/*
  剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000

作者：画手大鹏
链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xz2cf5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
/*
解题方案
思路
标签：字符串
最简单的方案自然是直接使用库函数啦！当然题目肯定是不希望我们这样做的！
增加一个新字符串，遍历原来的字符串，遍历过程中，如果非空格则将原来的字符直接拼接到新字符串中，如果遇到空格则将%20拼接到新字符串中
时间复杂度：O(n)O(n)，空间复杂度：O(n)O(n)

作者：画手大鹏
链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzn4b6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer05 {

    public String replaceSpace(String s) {

        if(s ==null || s.length()<1) return "";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            if(c ==' ') sb.append("%20");
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
