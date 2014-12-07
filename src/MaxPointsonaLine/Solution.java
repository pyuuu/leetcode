package MaxPointsonaLine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Decribation:
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 *
 * Created by xijueyp on 14-11-2.
 */
// todo 还没解决
public class Solution {
    public int maxPoints(Point[] points) {
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

            if (points.length <= 1)
                return points.length;

            Map<K, Integer> kMap = new HashMap<K, Integer>();

            int maxPointsonaLineNum = 0;

            boolean firstPoint = false;

            int repeat = 0;

            Arrays.sort(points);

            for (int i = 0; i != points.length; i += repeat + 1) {
                firstPoint = false;
                repeat = 0;
                // 计算重复了多少次
                for (int j = i + 1; j != points.length; j++) {
                    Point point1 = points[i];
                    Point point2 = points[j];

                    int subX = point1.x - point2.x;
                    int subY = point1.y - point2.y;

                    if (subX == 0 && subY == 0) {
                        repeat++;
                    }

                    K k;
                    if (subY == 0) {
                        k = new K(0, Integer.MAX_VALUE);
                    } else if (subX == 0) {
                        k = new K(0, 0);
                    } else {
                        int maxDivisor = divisor(subX, subY);

                        k = new K(subX / maxDivisor, subY / maxDivisor);
                    }

                    Integer aKNum = kMap.get(k);
                    if (aKNum == null) {
                        aKNum = 2 + repeat;
                        firstPoint = true;
                    } else if (firstPoint)
                        aKNum++;
                    kMap.put(k, aKNum);

                    if (aKNum > maxPointsonaLineNum)
                        maxPointsonaLineNum = aKNum;
                }
            }

            return maxPointsonaLineNum;
    }

    int  divisor( int  m, int  n){     // 方法一：循环法
        int  temp;

        if (n > m){
            divisor(n, m);
        }

        while (m % n != 0 ){
            temp = n;
            n = m % n;
            m = temp;
        }
        return  n;
    }

    class K extends Point{
        K(int x, int y){
            super(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof K) {
                K k = (K)o;
                return x == k.x && y == k.y;
            }
            return false;
        }

    }

    public static void main(String ap[]){
        Point[] points = new Point[]{new Point(0,0),new Point(1,1),new Point(1,-1)};

        System.out.println(new Solution().maxPoints(points));
    }
}

class Point implements Comparable{
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }

    @Override
    public int compareTo(Object o) {
        return hashCode();
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = result*31 + x;
        result = result*31 + y;
        return result;
    }
}
