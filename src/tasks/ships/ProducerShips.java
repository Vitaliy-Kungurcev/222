package tasks.ships;

public class ProducerShips implements Runnable {
   private Tonnel queue;

    public ProducerShips(Tonnel queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.addShip();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


