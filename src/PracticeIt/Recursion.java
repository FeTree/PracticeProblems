package PracticeIt;

public class Recursion {

    public String starString(int n) {
        if (n == 0) {
            return "*";
        }
        return starString(n - 1) + starString(n - 1);
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //Write a method writeNums that accepts an integer parameter n and prints the first n integers starting
    // with 1 in sequential order, separated by commas.
    public void writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n == 1) {
            System.out.print(1 + " ");
        } else {
            writeNums(n - 1);
            System.out.print(n + " ");
        }
    }

    public void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n == 1) {
            System.out.print("1");
        } else {
            System.out.print(n + " ");
            writeSequence(n - 1);
            System.out.print(" " + n);
        }
    }

    public void testQuestion(int n) {
        //n == 2
        int z = 2 * n;
        if (z < 1) {
            testQuestion(z);
        }
        System.out.println("z = " + z);
    }

    public static void main(String[] args) {
        Recursion test = new Recursion();

//        System.out.println(test.starString(2));
//        System.out.println(test.factorial(5));
//        System.out.println(test.fibonacci(2));
        test.writeNums(5);

        //test.testQuestion(4);
    }
}

