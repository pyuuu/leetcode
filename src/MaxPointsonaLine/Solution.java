package MaxPointsonaLine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xijueyp on 14-11-2.
 */
// todo 还没解决
public class Solution {
    public int maxPoints(Point[] points) {
        return 0;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Line{
    // y = kx+b
    double k, b;
    int count = 0;
    void inTheLine(Point point){
        if (point.y == k*point.x+b)
            count ++;
    }

    private Line(){}

}