package org.example;

import java.util.*;

public class Assignment3_3 {

    public static void main(String[] args) {
        // Task 1
        System.out.println("=== Task 1: Valid Palindrome ===");
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false

        // Task 2
        System.out.println("\n=== Task 2: Two Sum II ===");
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // [1, 2]

        // Task 3
        System.out.println("\n=== Task 3: 3Sum ===");
        List<List<Integer>> triplets = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        // Task 4
        System.out.println("\n=== Task 4: Container With Most Water ===");
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1})); // 1
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4})); // 16

        // Task 5
        System.out.println("\n=== Task 5: Trapping Rain Water ===");
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }

    // ==================== TASK 1: VALID PALINDROME ====================
    // Check if string is palindrome after removing non-alphanumeric chars
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // skip non-alphanumeric characters from left
            while (left < right && !isAlphaNum(s.charAt(left))) {
                left++;
            }
            // skip non-alphanumeric characters from right
            while (left < right && !isAlphaNum(s.charAt(right))) {
                right--;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // helper: check if character is letter or digit
    private static boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    // ==================== TASK 2: TWO SUM II (SORTED ARRAY) ====================
    // Find two numbers that sum to target, return indices (1-based)
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // +1 because problem uses 1-based indexing
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // should never happen (problem guarantees solution)
    }

    // ==================== TASK 3: 3SUM ====================
    // Find all triplets that sum to zero
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to use two pointers

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // ==================== TASK 4: CONTAINER WITH MOST WATER ====================
    // Find max area between two lines
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int water = width * minHeight;
            maxWater = Math.max(maxWater, water);

            // move the smaller height pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    // ==================== TASK 5: TRAPPING RAIN WATER ====================
    // Calculate how much water can be trapped
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}