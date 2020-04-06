package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//Q49
public class Q49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q49_GroupAnagrams q49GroupAnagrams = new Q49_GroupAnagrams();
        System.out.println(q49GroupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            String[] strArr = str.split("");
            Arrays.sort(strArr);

            String key = Arrays.toString(strArr);

            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            }else{
                ArrayList<String> strList = new ArrayList<>();
                strList.add(str);
                hashMap.put(key, strList);
            }
        }
        ret.addAll(hashMap.values());

        return ret;
    }
}
