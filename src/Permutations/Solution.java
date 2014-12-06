package Permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xijueyp on 14-11-11.
 */
public class Solution {

    List<List<Integer>> lists = new LinkedList<List<Integer>>();

    List<Integer> yuan = new LinkedList<Integer>();
    int n;

    public List<List<Integer>> permute(int[] num) {
        for (int i:num){
            yuan.add(i);
        }

        n = num.length;

        p(yuan, 0);

        return lists;
    }

    // 本次添加的integer，index上一个值被确定
    public void p(List<Integer> integers, int index){
        if (index == n - 1){
            lists.add(new LinkedList<Integer>(integers));
            return;
        }

        Integer now  = integers.get(index);

        for (int i=index+1;i != n;i++){
            // change
            List<Integer> cy = copy(integers);
            cy.set(index, cy.get(i));
            cy.set(i, now);
            p(cy, index - 1);
        }
    }

    public List<Integer> copy(List<Integer> integers){
        List<Integer> integerList = new LinkedList<Integer>();
        for (Integer integer : integers){
            integerList.add(integer);
        }
        return integerList;
    }

}