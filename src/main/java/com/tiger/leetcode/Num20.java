package com.tiger.leetcode;

import java.util.*;

public class Num20 {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Map<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        char[] array = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<array.length;i++){
            char c = array[i];
            if(hashMap.containsKey(c)){
                if(stack !=null && stack.peek() !=hashMap.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
