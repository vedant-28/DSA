public class OddEvenPrinter {
    private int counter = 1;
    private static int length = 10;

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());
        evenThread.start();
        oddThread.start();
    }

    public void printEven() {
        synchronized(this) {
            while(counter < length) {
                while(counter % 2 == 1) {
                    try { wait(); } catch(InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.println(counter++);
                notifyAll();
            }
        }
    }

    public void printOdd() {
        synchronized(this) {
            while(counter < length) {
                while(counter % 2 == 0) {
                    try { wait(); } catch(InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.println(counter++);
                notifyAll();
            }
        }
    }
    
}
