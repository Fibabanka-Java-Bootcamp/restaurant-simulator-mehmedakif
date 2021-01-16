package org.kodluyoruz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static org.kodluyoruz.Restaurant.ordersToTake;

public class Customer extends Thread
{
    private Semaphore sem;
    private String customerName;

    public Customer(Semaphore sem, String customerName)
    {
        this.sem = sem;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        System.out.println(customerName + " masaya oturdu.");
            try
            {
                System.out.println(customerName + " siparis veriyor.");
                sem.acquire();
                ordersToTake.add(customerName);
                Thread.sleep(1000);//Musteri masada 1000 saniye oturuyor.

            } catch (InterruptedException e)
            {
                System.out.println(customerName + " kovuldu.");
            }
        System.out.println(customerName + " masadan kalkti!");
    }
}
