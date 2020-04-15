package LeetCode;

import java.util.*;

class LeetCode {

    // https://leetcode.com/problems/multiply-strings/
    public String multiply(String num1, String num2) {
        Integer value1 = Integer.parseInt(num1);
        Integer value2 = Integer.parseInt(num2);

        return Integer.toString(value1 * value2);
    }

    public double twentyFour(double n, double a) {
        if (n == 1) {
            return Math.pow(2, Math.pow(2, n));
        } else {
            return twentyFour(n - 1, a) * twentyFour(n - 1, a);
        }
    }

    void printNumber(int num) {
        if (num != 0) {
            printNumber(num / 10);
            System.out.printf("%d", num % 10);
        }
    }

    public boolean isHappy(int n) {

        HashSet<Integer> seenNumbers = new HashSet<Integer>();

        while (seenNumbers.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
                System.out.println("sum= " + sum + " n=" + n);
            }
            n = sum;
            if (n == 1)
                return true;
            //System.out.println(n);
        }
        return false;
    }

    public int maxSubArray(int[] nums) {

        int answer = 0;
        int temp;

        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = 1; j < nums.length; j++) {
                temp += nums[j];
                answer += temp;
            }
        }

        return answer;
    }

    public boolean backspaceCompare(String S, String T) {
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (char c : sArr) {
            if (c != '#') {
                sStack.push(c);
            } else if (c == '#') {
                sStack.pop();
            }
        }

        for (char c : tArr) {
            if (c != '#') {
                tStack.push(c);
            } else if (c == '#' && !tStack.isEmpty()) {
                tStack.pop();
            }
        }

        String newS = "";
        String newT = "";
        for (int i = 0; i < sStack.size(); i++) {
            newS += sStack.pop();
        }
        for (int i = 0; i < tStack.size(); i++) {
            newT += tStack.pop();
        }
        return newS.equals(newT);
    }

    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int i : arr) {
            set.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) {
                count++;
            }
        }

        return count;
    }

    public int lastStoneWeight(int[] stones) {
        int weight = 0;

        //sort array
        Arrays.sort(stones);

        //create list
        Stack<Integer> stoneStack = new Stack<>();

        //copy values into list
        for (int i : stones) {
            stoneStack.push(i);
        }
        System.out.println(stoneStack.toString());

        /*
        If x == y, both stones are totally destroyed;
        If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
         */
        int x;
        int y;

        while (stoneStack.size() > 1) {
            y = stoneStack.pop();
            x = stoneStack.pop();

            if (x == y) {
                x = 0;
                y = 0;
            }

            if (x != y) {
                y = y - x;
                stoneStack.push(y); //push y back since has not been destroyed

                //copy to array to resort
                ArrayList<Integer> recopy = new ArrayList<>();
                for (Integer i : stoneStack) {
                    recopy.add(i);
                }
                Collections.sort(recopy);
                stoneStack.clear();
                for (Integer i : recopy) {
                    stoneStack.push(i);
                }
            }

        }
        //System.out.println(stoneStack.toString());

        if (stoneStack.isEmpty()) {
            return 0;
        }
        weight = stoneStack.peek();
        return weight;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        //put sum and nodez as globals if u wanna run this, david
        int sum = 0;
        ArrayList<TreeNode> nodez = new ArrayList<>();
        inOrderAddTraversal(root);

        for (int i = 0; i < nodez.size(); i++) {
            if (nodez.get(i).val >= L && nodez.get(i).val <= R) {
                sum += nodez.get(i).val;
            }

        }

        return sum;
    }

    public void inOrderAddTraversal(TreeNode root) {
        //helper funtion for rangeSumBST, adds all nodes to a list
        if (root == null) {
            return;
        }
        //nodez.add(root);
        inOrderAddTraversal(root.left);
        inOrderAddTraversal(root.right);
    }

    public String stringShift(String s, int[][] shift) {
        String answer = s;
        boolean left;
        boolean right;
        Queue queue = new LinkedList();
        queue = addColumnsToList(shift);

        while(!queue.isEmpty()) {

            int leftOrRight = (int) queue.poll();
            int numOfShifts = (int) queue.poll();

            System.out.println("left or right: " + leftOrRight);
            System.out.println("Num of rotations: " + numOfShifts);
            System.out.println("answer: " + answer);

            if(leftOrRight == 0){
                left = true;
                right = false;
                System.out.println("Shifting left...");
                answer = leftrotate(answer, numOfShifts );
            }

            if(leftOrRight == 1){
                left = false;
                right = true;
                System.out.println("Shifting right...");
                answer = rightrotate(answer, numOfShifts);
            }
        }

        return answer;
    }

    // function that rotates s towards left by d
    String leftrotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    // function that rotates s towards right by d
    String rightrotate(String str, int d) {
        return leftrotate(str, str.length() - d);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int totalProduct = 1;

        for (int i = 0; i < nums.length ; i++) {
            totalProduct *= nums[i];
        }

        System.out.println("Total product: " + totalProduct);

        if (totalProduct == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = totalProduct / nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode lc = new LeetCode();

        // stringShift testing
        String s = "abc";
        int[] shift = {1 , 0};
        int[] ans = lc.productExceptSelf(shift);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }



    }

    public Queue addColumnsToList(int[][] arr) {
        Queue<Integer> IList = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                IList.add(arr[i][j]);
            }
        }

        return IList;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class MinStack {
        Node top;
        Node min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            top = null;
            min = null;
            ;
        }

        public void push(int x) {
            Node prevTop = top;
            Node newNode = new Node();
            newNode.value = x;
            newNode.next = prevTop;
            top = newNode;

            //first time called
            boolean flag = true;
            if (flag) {
                min = newNode;
                flag = false;
            } else if (newNode.value < min.value) {
                min = newNode;
            }

        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
            }
            Node popped = top;
            top = top.next;
            System.out.println("popped: " + popped.value);
            //return popped.value;
        }

        public int top() {
            if (isEmpty()) {
                System.out.println("Empty, top is null");
                return -1;
            }
            return top.value;
        }

        public int getMin() {
            if (isEmpty()) {
                System.out.println("Empty, min is null");
                return -1;
            }

            Node minCheck = top;
            int minValue = Integer.MAX_VALUE;

            while (minCheck != null) {
                if (minValue > minCheck.value) {
                    minValue = minCheck.value;
                }
                minCheck = minCheck.next;
            }
            return minValue;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    class Node {
        int value;
        Node next;
    }

}