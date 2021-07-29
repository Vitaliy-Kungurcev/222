package tasks.ships;

public class StartProcess {
    public static void main(String[] args) throws InterruptedException {
        Tonnel tonnel = new Tonnel();
        ProducerShips producerShips = new ProducerShips(tonnel);
        Berth berthFruits = new Berth(Product.FRUITS, tonnel);
        Berth berthClothes = new Berth(Product.CLOTHES, tonnel);
        Berth berthCars = new Berth(Product.CARS, tonnel);

        Thread threadProducerShips = new Thread(producerShips);
        Thread threadBerthFruits = new Thread(berthFruits);
        Thread threadBerthClothes = new Thread(berthClothes);
        Thread threadBerthCars = new Thread(berthCars);

        threadProducerShips.setName("PRODUCER-Thread");
        threadBerthFruits.setName("FRUITS-Thread");
        threadBerthClothes.setName("CLOSES-Thread");
        threadBerthCars.setName("CARS-Thread");

        threadProducerShips.start();
        System.out.println("------Производитель кораблей начал работать-----");
        threadProducerShips.join(12000);
        threadBerthFruits.start();
        System.out.println("------Причал с фруктами начал работу-----");
        threadBerthFruits.join(2000);
        threadBerthClothes.start();
        System.out.println("------Причал с одеждой начал работу-----");
        threadBerthClothes.join(2000);
        threadBerthCars.start();
        System.out.println("------Причал с автомобилями начал работу-----");

    }
}

