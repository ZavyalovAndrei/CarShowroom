import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        final int buyerQuantity = 10;
        final int threadQuantity = 4;
        final CarShowroom carShowroom = new CarShowroom();
        final ExecutorService threadPool =  Executors.newFixedThreadPool(threadQuantity);

        for (int i = 0; i < buyerQuantity; i++) {

            threadPool.execute(new BuyerRunnable(carShowroom, i));
            threadPool.execute(new ManufacturerRunnable(carShowroom));
        }
        threadPool.shutdown();
    }
}


