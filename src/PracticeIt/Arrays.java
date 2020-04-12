package PracticeIt;

import java.util.*;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Arrays {

    //method countStrings that takes an array of Strings and a target String and returns the number
    // of occurences target appears in the array.
    public int countStrings(String[] arr, String target) {
        int timesFound = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                timesFound++;
            }
        }
        return timesFound;
    }

    //Write a method called equals that takes in two string arrays and returns true if they are equal;
    // that is, if both arrays have the same length and contain equivalent string values at each index.
    public boolean equals(String[] arrOne, String[] arrTwo) {
        int checker = 0;
        if (arrOne.length == arrTwo.length) {
            //check each index
            int length = arrOne.length;
            for (int i = 0; i < length; i++) {
                if (arrOne[i] == arrTwo[i]) {
                    checker++;
                }
            }
        }
        if (checker == arrOne.length) {
            return true;
        }
        return false;
    }

    public int[] removeDuplicates(int[] arr) {
        int length = arr.length;
        int temp[] = new int[length];
        //find number of duplicates
        int duplicates = 0;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                duplicates++;
            }
        }
        int j = 0;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j++] = arr[length - 1]; // add last element into new arr
        //trim array
        int newLength = length - duplicates;
        int[] noDupes = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            noDupes[i] = arr[i];
        }
        return noDupes;
    }

    //find most frequent val in array
    public int mostFrequent(int[] arr) {
        int length = arr.length;
        int j = 0;
        int occurence = 0;
        for (int i = 0; i < length; i++) {
            if (arr[j] == arr[i]) {
                occurence++;
            }
        }
        return 0;
    }

    public int[] findNumbersAddingToTen(int[] arr) {
        int target = 10;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int minus = target - arr[i];
            if (map.containsKey(minus)) {
                return new int[]{map.get(minus), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        String morseFinal = "";
        for (int i = 0; i < words.length; i++) {
            set.add(morse[i]);
        }
        for (int i = 0; i < set.size(); i++) {

        }
        return 5;
    }

    public int balancedStringSplit(String s) {
        int length = s.length();
        int rCount = 0;
        int lCount = 0;
        int ways = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == 'R') {
                rCount++;
            }
            if (c == 'L') {
                lCount++;
            }
            if (lCount == rCount) {
                ways++;
            }
        }
        return ways;
    }

    //target = 9 should return the array [0, 1] since 2 + 7 = 9 (nums[0] + nums[1] = 9)
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] ansArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Input: [3,1,2,4]
    // Output: [2,4,3,1]
    // sort by even then odd
    public int[] sortArrayByParity(int[] A) {
        int[] ansArr = new int[A.length];

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ansArr[index] = A[i];
                index++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                ansArr[index] = A[i];
                index++;
            }
        }
        return ansArr;
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        java.util.Arrays.sort(A);
        return A;
    }


    public static void main(String args[]) {
        Arrays test = new Arrays();
        int[] numbers = {-4, -1, 0, 3, 10}; // target = 9
        int[] yoyo = test.sortedSquares(numbers);

        for (int i = 0; i < yoyo.length; i++) {
            System.out.print(yoyo[i] + " ");
        }

    }
}

