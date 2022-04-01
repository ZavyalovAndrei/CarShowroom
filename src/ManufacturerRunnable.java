public class ManufacturerRunnable implements Runnable{

    CarShowroom carShowroom;

    public ManufacturerRunnable(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Производитель Ford");
        carShowroom.acceptCar();
    }
}