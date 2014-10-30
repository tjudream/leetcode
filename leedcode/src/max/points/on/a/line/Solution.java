package max.points.on.a.line;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maxPoints(Point[] points) {
        int max = 0;
        for (int i=0;i<points.length;i++) {
        	if (max > points.length - i) break;
        	Map<Double,Integer> map = new HashMap<Double,Integer>();
        	int localmax = 1;
        	int noSlopeNum = 1;
        	int samePointNum = 0;
        	for (int j=i+1;j<points.length;j++) {
        		if (points[i].x == points[j].x && points[i].y == points[j].y) {
        			//the same points
        			samePointNum++;
        		} else if (points[i].x == points[j].x) {
        			//no slope likes x=c
        			noSlopeNum++;
        		} else if (points[i].y == points[j].y) {
        			//double contains +/- zero
        			if (map.containsKey(0.0)) {
        				int num = map.get(0.0);
        				num++;
        				map.put(0.0, num);
        				if (localmax < num) localmax = num;
        			} else {
        				map.put(0.0, 2);
        				if (localmax < 2) localmax = 2;
        			}
        			
        		} else {
        			double slope = (double)(points[i].y - points[j].y)/(points[i].x - points[j].x);
        			if (map.containsKey(slope)) {
        				int num = map.get(slope);
        				num++;
        				map.put(slope, num);
        				if (localmax < num) localmax = num;
        			} else {
        				map.put(slope, 2);
        				if (localmax < 2) localmax = 2;
        			}
        		}
        	}
        	if (localmax < noSlopeNum) localmax = noSlopeNum;
        	localmax += samePointNum;
        	if (max < localmax) max = localmax;
        }
        return max;
    }
	
	public static void main(String[] args) {
		//Point[] points = new Point[]{new Point(0,0), new Point(0,1)};
		Point[] points = new Point[]{new Point(2,3), new Point(3,3), new Point(-5,3)};
		Solution s = new Solution();
		System.out.println(s.maxPoints(points));
	}
}
