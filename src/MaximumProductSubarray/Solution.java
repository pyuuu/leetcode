package MaximumProductSubarray;

/**
 * Created by xijueyp on 14-11-1.
 */
public class Solution {

    // 找0 ，按0分割然后递归
    public int maxProduct(int[] A) {
        // 消去最开始的0
        boolean flag = false;
        int max = A[0];
        int size = A.length;
        int head = 0;

        while(head<size && A[head]==0)
            head++;
        if (head >= size)
            return 0;
        if (head!=0)
            flag = true;

        max = A[head];
        for (int tail =head ;tail< size; tail++){
            while (tail < size && A[tail] != 0){
                tail ++;
            }
            if (tail != size)
                flag = true;
            int p = maxP(A, head, tail-1);
            if (p > max && p!=0)
                max = p;
            head = tail + 1;
        }
        if (flag)
            return Math.max(max, 0);
        return max;
    }

    // 不考虑 0 的情况
    public int maxP(int A[], int head, int tail){
        if (head >= tail)
            return A[head];
        int last = -1;
        int first = -1;
        int count = 0;

        int lastPart = 1;
        int firstPart = 1;
        int mid = 1;

        // 累乘head到first-1之前的数据
        for (int i = head;i <= tail ;i++){
            if (A[i]<0){
                first = i;
                break;
            }
            firstPart *= A[i];
        }

        if (first == -1)
            return firstPart;

        // 累乘last+1到tail
        for (int i=tail;i > first;i--){
            if (A[i]<0 ){
                last = i;
                break;
            }
            lastPart *= A[i];
        }
        if (last == -1)
            last = first;

        // first+1 last-1
        for (int i = first+1;i!=0&& i<last && last!=first;i++){
            if (A[i]<0){
                count ++;
            }
            mid *= A[i];
        }

        if (first != last)
            count += 2;
        else
            count += 1;

        if (first == -1)
            count = 0;

        if (count%2 == 0){
            // 全乘上

            if (first == -1){
                return firstPart * mid * lastPart;
            }
            return firstPart * A[first] * mid * A[last] * lastPart;
        }
        else {
            // 取两边
            if (first == last)
                return Math.max(firstPart, lastPart);
            return Math.max(firstPart * A[first]* mid, mid * A[last] *lastPart );
        }

    }

    public static void main(String ap[]){
        int [] a = {-4,-3,-2};
        System.out.println( new Solution().maxProduct(a)  );
    }
}
