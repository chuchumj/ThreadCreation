// just one thread printing. Will stop when it prints up to 7 x's
// printing time interval was taken from the scanner

import java.util.Scanner;
class ThreadingPattern1 {

    public static void runningThreading(String message, int milli) {
        new Thread(() -> {
            int i = 0;
            while (i < 7) {
                try {
                    Thread.sleep(milli);
                    i++;
                } catch (InterruptedException e) {
                    System.out.println("I caught it an exception");
                }
                System.out.println(message);
            }
        }).start();
    }

    // method to check when the sleep time is too small( should not be <1000)
    public static void checker(int i) throws Exception {
        if (i < 1000) {
            throw new Exception("number is less than 1000");
        }
    }

    public static void main(String[] args) {
        ThreadingPattern1 tp = new ThreadingPattern1();
        Scanner scan = new Scanner(System.in);
        int sec = scan.nextInt();
        try {
            checker(sec);
        } catch (Exception e) {
            System.out.printf("This is not allowed");
        }
        tp.runningThreading("x", sec);
    }
}


