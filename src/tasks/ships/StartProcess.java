package tasks.ships;

public class StartProcess {
    public static void main(String[] args) throws InterruptedException {
        QueueOfShips queueOfShips=new QueueOfShips();
        queueOfShips.start();
        System.out.println("Тоннель начал работу");
        queueOfShips.join(2000);

        Berth berthFruits = new Berth(Product.FRUITS);
        Berth berthClothes = new Berth(Product.CLOTHES);
        Berth berthCars = new Berth(Product.CARS);
        berthFruits.start();
        System.out.println("Причал с фруктами начал работу");
        berthClothes.start();
        System.out.println("Причал с одеждой начал работу");
        berthCars.start();
        System.out.println("Причал с автомобилями начал работу");
    }
}

