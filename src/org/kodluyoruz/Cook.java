package org.kodluyoruz;

import java.util.concurrent.Semaphore;

import static org.kodluyoruz.Restaurant.cookOrder;

public class Cook extends Thread
{
    private Semaphore sem;
    private String cookName;

    public Cook(Semaphore sem, String waiterName)
    {
        this.sem = sem;
        this.cookName = cookName;
    }
    @Override
    public void run() {
        System.out.println(cookName + " siparisi mutfakta hazilaniyor.");

        for (int i = 0; i < 10; i++)
        {
            try
            {
                sem.acquire();
                cookOrder(Restaurant.ordersToCook.get(0));
                Thread.sleep(1000);
                System.out.println("In " + cookName + " count is " + i);
            } catch (InterruptedException e)
            {
                System.out.println(cookName + " is interrupted");
            }
        }
        System.out.println(cookName + " hazir!");
    }
}
