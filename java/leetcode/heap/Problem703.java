package leetcode.heap;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 */
public class Problem703 {

    PriorityQueue<Integer> klargestq;
    int k;

    public Problem703(int k, int[] nums) {
        klargestq = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        klargestq.add(val);
        if(klargestq.size() > k)
            klargestq.poll();

        return klargestq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        Problem703 kthLargest = new Problem703(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8

    }

}