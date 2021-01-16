package org.kodluyoruz;

import java.util.concurrent.Semaphore;

import static org.kodluyoruz.Restaurant.*;

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
                if(ordersToTake > 0)
                {
                    sem.acquire();
                    System.out.println(waiterName + " is siparisi mutfaga iletiyor.");
                    ordersToTake -= 1;
                    ordersToCook += 1;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e)
            {
                System.out.println(waiterName + " siparisi unuttu.");
            }
        System.out.println(waiterName + " bosta!");
    }
}
