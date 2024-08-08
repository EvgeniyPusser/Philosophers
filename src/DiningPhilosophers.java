public class DiningPhilosophers {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Fork[] forks = new Fork[numberOfPhilosophers];

        // Create forks
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Fork();
        }

        // Create philosophers and start their threads
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, 3);
            philosophers[i].start();
        }

        // Wait for all philosophers to finish
        for (int i = 0; i < numberOfPhilosophers; i++) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All philosophers have finished eating.");
    }
}
