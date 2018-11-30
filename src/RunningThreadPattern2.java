
// two threads alternating and printing indefinately

class ThreadingPattern2  {

    static void printB(String message , int milli){
        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(milli);
                }catch(InterruptedException e){
                    System.out.println("terrible things happen");
                }
                        System.out.println(message);
                }
            }).start();
    }

    static void printA (String message, int milli){
            new Thread(()-> {
                while (true) {
                    try {
                        Thread.sleep(milli);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(message);
                }
            }).start();
        }

    public static void main( String[] args){
        printB("b", 1000);
        printA("a", 1500);
    }
}

