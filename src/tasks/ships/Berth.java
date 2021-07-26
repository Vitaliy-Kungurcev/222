package tasks.ships;

public class Berth extends Thread {
    private Product product;
    QueueOfShips queueOfShips = new QueueOfShips();

    public Berth(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Ship ship = queueOfShips.giveTheShipFoLoading(this.product);
                if (ship == null) {
                    System.out.println("В тоннеле нет  корабля для " + product + ",ожидаем. " +
                            "Список доступных кораблей: " + QueueOfShips.tunnel.toString());
                    Thread.sleep(1000);
                } else {
                    QueueOfShips.tunnel.remove(ship);
                    System.out.println("Из туннеля вышел: " + ship);
                    System.out.println("Начинается погрузка на корабль " + ship);

                    Thread.sleep(ship.getSizeShip().size * 100);

                    System.out.println("Погрузка на " + ship + " окончена.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
