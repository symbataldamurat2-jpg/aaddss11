package org.example;

import java.util.*;

public class Assignment3_2 {

    public static void main(String[] args) {
        System.out.println("=== Task 1: Last Stone Weight ===");
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1})); // 1

        System.out.println("\n=== Task 5: Kth Largest Element in Array ===");
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5

        System.out.println("\n=== Task 6: K Closest Points to Origin ===");
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] result = kClosest(points, 2);
        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }
    }

    // ==================== TASK 1: LAST STONE WEIGHT ====================
    // Using max heap (PriorityQueue with reverse order)
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            if (x != y) {
                maxHeap.add(y - x);
            }
            // if equal, both are destroyed (nothing to add)
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    // ==================== TASK 2: KTH LARGEST IN STREAM ====================
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>(); // min heap
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
            return minHeap.peek();
        }
    }

    // ==================== TASK 3: DESIGN TWITTER ====================
    static class Twitter {
        private Map<Integer, Set<Integer>> follows;
        private Map<Integer, List<Tweet>> userTweets;
        private int timeStamp;

        class Tweet {
            int tweetId;
            int time;
            Tweet(int tweetId, int time) {
                this.tweetId = tweetId;
                this.time = time;
            }
        }

        public Twitter() {
            follows = new HashMap<>();
            userTweets = new HashMap<>();
            timeStamp = 0;
        }

        public void postTweet(int userId, int tweetId) {
            userTweets.putIfAbsent(userId, new ArrayList<>());
            userTweets.get(userId).add(0, new Tweet(tweetId, timeStamp++)); // add to front
        }

        public void follow(int followerId, int followeeId) {
            follows.putIfAbsent(followerId, new HashSet<>());
            follows.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (follows.containsKey(followerId)) {
                follows.get(followerId).remove(followeeId);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Tweet> allTweets = new ArrayList<>();

            // add user's own tweets
            if (userTweets.containsKey(userId)) {
                allTweets.addAll(userTweets.get(userId));
            }

            // add followed users' tweets
            if (follows.containsKey(userId)) {
                for (int followeeId : follows.get(userId)) {
                    if (userTweets.containsKey(followeeId)) {
                        allTweets.addAll(userTweets.get(followeeId));
                    }
                }
            }

            // sort by time (newest first)
            allTweets.sort((a, b) -> b.time - a.time);

            // get top 10
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
                result.add(allTweets.get(i).tweetId);
            }
            return result;
        }
    }

    // ==================== TASK 4: TASK SCHEDULER ====================
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(result, tasks.length);
    }

    // ==================== TASK 5: KTH LARGEST ELEMENT IN ARRAY ====================
    // Using min heap approach (simpler for beginner)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // Alternative: Using sorting (even simpler but O(n log n))
    public static int findKthLargestSimple(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // ==================== TASK 6: K CLOSEST POINTS TO ORIGIN ====================
    public static int[][] kClosest(int[][] points, int k) {
        // array of (distance, index)
        double[][] distances = new double[points.length][2];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            distances[i][0] = Math.sqrt(x * x + y * y);
            distances[i][1] = i;
        }

        // sort by distance
        Arrays.sort(distances, (a, b) -> Double.compare(a[0], b[0]));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = (int) distances[i][1];
            result[i] = points[index];
        }

        return result;
    }

    // ==================== TASK 7: FIND MEDIAN FROM DATA STREAM ====================
    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // left half (smaller numbers)
        private PriorityQueue<Integer> minHeap; // right half (larger numbers)

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}