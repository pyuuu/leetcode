package MinStack;

import java.util.*;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Created by xijueyp on 14-12-5.
 *
 *
 * 遇到的问题：
 * 1. 第一种实现就是
 */
class MinStack {

    List<Integer> data = new Stack<Integer>();


    class Min {
        boolean minNeedChange = false;
        Integer min;
        int minIndex = -1;
    }

    private Min min = new Min();

    public void push(int x) {
        data.add(x);
        if (min.min == null || x < min.min) {
            min.min = x;
            min.minIndex = data.size() - 1;
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            int maxIndexBeforePop = data.size() - 1;
            data.remove(maxIndexBeforePop);
            if (min.minIndex == maxIndexBeforePop)
                min.minNeedChange = true;
        }
    }
    public int top() {
        if (data.isEmpty())
            return -1;
        return data.get(data.size() - 1);
    }

    public int getMin() {
        if (!min.minNeedChange)
            return min.min;

        int i = 0;
        int minIndex = 0;
        Integer newMin = data.get(0);
        for (Integer integer : data){
            if (integer < newMin){
                newMin = integer;
                minIndex = i;
            }
            i++;
        }
        min.minNeedChange = false;
        min.min = newMin;
        min.minIndex = minIndex;
        return newMin;
    }

    public int size(){
        return data.size();
    }

    public List<Integer> getData() {
        return data;
    }

    public static void main(String []arvg){
        MinStack minStack = new MinStack();
        minStack.pop();

        minStack.push(44);
        minStack.push(425);
        minStack.push(100);
        minStack.push(-1);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.getData().toString());
    }
}
