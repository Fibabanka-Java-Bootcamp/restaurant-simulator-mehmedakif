package org.kodluyoruz;

import java.util.concurrent.Semaphore;

import static org.kodluyoruz.Restaurant.takeOrder;

public class Waiter extends Thread
{
    private Semaphore sem;
    private String waiterName;

    public Waiter(Semaphore sem, String waiterName)
    {
        this.sem = sem;
        this.waiterName = waiterName;
    }
    @Override
    public void run() {
        System.out.println(waiterName + " siparisi aliyor.");
            try
            {
                System.out.println(waiterName + " is siparisi mutfaga iletiyor.");
                sem.acquire();
                takeOrder(Restaurant.ordersToTake.get(0));

                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                System.out.println(waiterName + " siparisi unuttu.");
            }
        System.out.println(waiterName + " bosta!");
    }
}
