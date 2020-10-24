package com.tiger.interview.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
 *
 * Return that integer
 */
public class FindSpecialInteger {

    /**
     * so easy
     * @param arr
     * @return
     * @throws Exception
     */
    public int findSpecialInteger(int[] arr) throws Exception{
        Map<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
        for(int i =0;i<arr.length;i++){
            if(resultMap.get(arr[i]) != null){
                resultMap.put(arr[i],resultMap.get(arr[i])+1);
            }else{
                resultMap.put(arr[i],1);
            }
        }
        Set<Map.Entry<Integer,Integer>> entrys = resultMap.entrySet();
        for(Map.Entry entry:entrys){
            if((Integer)entry.getValue()>arr.length/4){
                return (Integer)entry.getKey();
            }
        }
        throw new Exception("can not find correct number");
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,3,3};
        try{
            System.out.println(new FindSpecialInteger().findSpecialInteger(arr));

        } catch(Exception e){

        }

    }
}
