package tasks.ships;

public class Berth implements Runnable {
    private Product product;
    private Tonnel tonnel;

    public Berth(Product product, Tonnel tonnel) {
        this.product = product;
        this.tonnel = tonnel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName()+": Запрос в тоннель на корабль");
                Ship ship = tonnel.giveTheShipFoLoading(this.product);

                System.out.println(Thread.currentThread().getName()+": Начинается погрузка на корабль" );
                Thread.sleep(ship.getSizeShip().size * 200);

                System.out.println(Thread.currentThread().getName()+": Погрузка закончена");
                System.out.println(Thread.currentThread().getName()+": Причал готов к работе.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
