public class AlternatePrinter {
    private final Object lock = new Object();
    private boolean numberTurn = true;

    public static void main(String[] args) {
        AlternatePrinter printer = new AlternatePrinter();
        Thread numberThread = new Thread(() -> printer.printNumber());
        Thread letterThread = new Thread(() -> printer.printLetter());
        numberThread.start();
        letterThread.start();
    }

    public void printNumber() {
        for(int i = 1; i <= 26; i++) {
            synchronized(lock) {
                while(!numberTurn) {
                    try {
                        lock.wait();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i + " ");
                numberTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void printLetter() {
        for(char c = 'A'; c <= 'Z'; c++) {
            synchronized(lock) {
                while(numberTurn) {
                    try {
                        lock.wait();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(c + " ");
                numberTurn = true;
                lock.notifyAll();
            }
        }
    }
}
