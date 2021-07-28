package tasks.ships;

public class StartProcess {
    public static void main(String[] args) throws InterruptedException {
        Tonnel tonnel = new Tonnel();
        ProducerShips producerShips = new ProducerShips(tonnel);
        Berth berthFruits = new Berth(Product.FRUITS, tonnel);
        Berth berthClothes = new Berth(Product.CLOTHES, tonnel);
        Berth berthCars = new Berth(Product.CARS, tonnel);

        Thread thread1 = new Thread(producerShips);
        Thread thread2 = new Thread(berthFruits);
        Thread thread3 = new Thread(berthClothes);
        Thread thread4 = new Thread(berthCars);

        thread1.setName("PRODUCER-Thread");
        thread2.setName("FRUITS-Thread");
        thread3.setName("CLOSES-Thread");
        thread4.setName("CARS-Thread");

        thread1.start();
        System.out.println("------Производитель кораблей начал работать-----");
        thread1.join(16000);
        thread2.start();
        System.out.println("------Причал с фруктами начал работу-----");
        thread2.join(3000);
        thread3.start();
        System.out.println("------Причал с одеждой начал работу-----");
        thread3.join(3000);
        thread4.start();
        System.out.println("------Причал с автомобилями начал работу-----");

    }
}

