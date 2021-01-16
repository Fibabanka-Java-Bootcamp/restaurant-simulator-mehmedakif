package org.kodluyoruz;

import java.util.concurrent.Semaphore;

import static org.kodluyoruz.Restaurant.*;

public class Cook extends Thread
{
    private Semaphore sem;
    private String cookName;

    public Cook(Semaphore sem, String cookName)
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
                if(ordersToCook > 0)
                {
                    sem.acquire();
                    ordersToCook -=1;
                    ordersToServe +=1;
                    System.out.println("In " + cookName + " count is " + i);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e)
            {
                System.out.println(cookName + " is interrupted");
            }
        }
        System.out.println(cookName + " hazir!");
    }
}
