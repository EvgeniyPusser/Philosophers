public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final int eatTimes;

    public Philosopher(int id, Fork leftFork, Fork rightFork, int eatTimes) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatTimes = eatTimes;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < eatTimes; i++) {
                // Think
                System.out.println("Philosopher " + (id + 1) + " is thinking.");
                Thread.sleep((long)(Math.random() * 100));

                // Pick up forks
                leftFork.pickUp();
                System.out.println("Philosopher " + (id + 1) +" picked up left fork.");
                rightFork.pickUp();
                System.out.println("Philosopher " + (id + 1)  + " picked up right fork.");

                // Eat
                System.out.println("Philosopher " + (id + 1) + " is eating.");
                Thread.sleep((long)(Math.random() * 100));

                // Put down forks
                leftFork.putDown();
                System.out.println("Philosopher " + (id + 1) +" put down left fork.");
                rightFork.putDown();
                System.out.println("Philosopher " + (id + 1) +" put down right fork.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}