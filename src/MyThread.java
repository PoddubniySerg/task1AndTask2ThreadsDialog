class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Всем привет! Я поток " + Thread.currentThread().getName());
            }
        } catch (InterruptedException err) {
            System.out.println(Thread.currentThread().getName() + err.getMessage());
        } finally {
            System.out.printf("%s завершен\n", getName());
        }
    }
}