package org.kodluyoruz;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Restaurant
{
    static Semaphore sem;
    static int ordersToTake = 0;
    static int ordersToCook = 0;
    static int ordersToServe = 0;

    static ExecutorService waiterPool = Executors.newFixedThreadPool(3);
    static ExecutorService cookPool = Executors.newFixedThreadPool(2);

}
