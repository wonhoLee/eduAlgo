package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal2 {
    public static void main(String[] args) {
        int rowIndex = 3;

        Pascal2 pascal2 = new Pascal2();
        System.out.println(pascal2.getRow(rowIndex));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if(rowIndex == 0){
            ret.add(1);
            return ret;
        }else if (rowIndex == 1){
            ret.add(1);
            ret.add(1);
            return ret;
        }else{
            ret.add(1);
            ret.add(1);
        }

        return helper(ret, rowIndex-1);
    }

    public List<Integer> helper(List<Integer> list, int rowIndex){
        if(rowIndex == 0) return list;

        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i -1) + list.get(i);
            ret.add(val);
        }
        ret.add(1);

        return helper(ret, --rowIndex);
    }
}
