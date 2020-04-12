package PracticeIt;

import java.util.Collections;
import java.util.Iterator;
import java.util.*;

public class StackAndQueues {
    Iterator<Stack> iter = new Iterator<Stack>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Stack next() {
            return null;
        }
    };

    //Write a method splitStack that takes a stack of integers
    // as a parameter and splits it into negatives and non-negatives.
    //print in a queue
    public void splitStack(Stack<Integer> stack) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //separate negs and pos
        while (stack.iterator().hasNext()) {
            int popped = stack.peek();
            if (popped < 0) {
                negatives.add(popped);
            }
            if(popped >= 0){
                positives.add(popped);
            }
            stack.pop();
        }
        // add negatives to queue
        for (int i = 0; i <negatives.size(); i++) {
            queue.add(negatives.get(i));
        }
        // add positives
        for (int i = 0; i <positives.size(); i++) {
            queue.add(positives.get(i));
        }
        System.out.println(queue);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-5);
        stack.push(7);
        stack.push(0);
        stack.push(-6);
        stack.push(4);
        StackAndQueues app = new StackAndQueues();
        app.splitStack(stack);
        //System.out.println(stack.iterator().next());
    }
}

