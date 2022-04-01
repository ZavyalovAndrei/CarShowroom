public class BuyerRunnable implements Runnable {
    CarShowroom carShowroom;
    int buyerNum;

    public BuyerRunnable(CarShowroom carShowroom, int buyerNum) {
        this.carShowroom = carShowroom;
        this.buyerNum = buyerNum + 1;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Покупатель №" + buyerNum);
        carShowroom.sellCar();
        buyerNum++;
    }
}