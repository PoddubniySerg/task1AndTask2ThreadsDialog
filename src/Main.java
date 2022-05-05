public class Main {

    public static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("main group");
        for (int i = 0; i < THREAD_COUNT; i++) {
            new MyThread(threadGroup, "thread" + i).start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            threadGroup.interrupt();
            System.out.println("The end.");
        }
    }
}
