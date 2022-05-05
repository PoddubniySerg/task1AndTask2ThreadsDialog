import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private Integer count;
    private final int maxMessageCount;

    public MyCallable(int maxMessageCount) {
        this.maxMessageCount = maxMessageCount;
        this.count = 0;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < new Random().nextInt(this.maxMessageCount); i++) {
            this.count += 1;
            System.out.println("Всем привет! Я поток " + Thread.currentThread().getName());
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
            }
        }
        return this.count;
    }
}
