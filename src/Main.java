import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static final int TASKS_COUNT = 4;
    public static final int MAX_MESSAGE_COUNT = 10;

    public static void main(String[] args) {
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Integer> resultList = new ArrayList<>();
        try {
            System.out.println("1. Получение списка результатов всех задач:");
            for (Future<Integer> result : threadPool.invokeAll(getTasks())) {
                resultList.add(result.get());
            }
            System.out.println(resultList);
            System.out.println("\n\n2. Получение самого быстрого результата из пулла потоков");
            System.out.println("Результат: " + threadPool.invokeAny(getTasks()));
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        } finally {
            threadPool.shutdown();
        }
    }

    public static Collection<Callable<Integer>> getTasks() {
        Collection<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < TASKS_COUNT; i++) {
            tasks.add(new MyCallable(MAX_MESSAGE_COUNT));
        }
        return tasks;
    }
}
