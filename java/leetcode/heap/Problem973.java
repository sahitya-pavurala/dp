package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */
public class Problem973 {

    private static int[][] solution(int [][] points, int K) {

        PriorityQueue<Point> closest = new PriorityQueue<>(new PointComparator());
        for(int[] point: points)
            closest.add(new Point(point[0], point[1]));

        int[][] result = new int[K][2];
        int i = 0;
        while(i < K){
            Point p = closest.poll();
            result[i++] = new int[]{p.x, p.y};
        }

        return result;
    }

    private static double getDistance(Point p){
        return Math.sqrt(p.x*p.x + p.y*p.y);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,3}, {-2, 2}}, 1));
    }

    static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
           double check = getDistance(p1) - getDistance(p2);
           if (check > 0)
               return 1;
           else if (check == 0)
               return 0;
           else return -1;
        }
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}