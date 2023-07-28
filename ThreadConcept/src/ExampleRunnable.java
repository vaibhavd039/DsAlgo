public class ExampleRunnable {
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.start();
        thread1.join(2000);
        thread2.start();
        thread2.join();
        thread3.start();
    }

}
