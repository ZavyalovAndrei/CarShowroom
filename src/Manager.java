public class Manager {

    private final CarShowroom carShowroom;
    private static final int RELEASE_NEW_CAR_DELAY = 2000;
    private static final int NEW_BUYER_COME_DELAY = 500;
    private static final int SELL_CAR_DELAY = 100;
    protected int SOLD_CARS = 0;

    public Manager(CarShowroom carShowroom) {
    this.carShowroom = carShowroom;
    }

    public synchronized void receiveCar() {
        try {
            Thread.sleep(RELEASE_NEW_CAR_DELAY);
            carShowroom.getCarList().add(carShowroom.getNewCar());
            System.out.println("Производитель Ford: Выпущен 1 автомобиль.");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            Thread.sleep(NEW_BUYER_COME_DELAY);
            System.out.println(Thread.currentThread().getName() +" зашел в автосалон.");
            while (carShowroom.getCarList().size() == 0) {
                System.out.println("Менеджер: Автомобилей нет!");
                wait();
            }
            Thread.sleep(SELL_CAR_DELAY);
            System.out.println("Продавец: " + Thread.currentThread().getName() +
                    " уехал на новеньком автомобиле:" + carShowroom.getCar().toString().replace("]", "")
                    .replace("[",""));
            SOLD_CARS++;
            System.out.println("Продано: " + SOLD_CARS + " автомобилей");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShowroom.getCarList().remove(0);
    }

    public int getSOLD_CARS() {
        return SOLD_CARS;
    }
}