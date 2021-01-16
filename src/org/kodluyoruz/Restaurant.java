package org.kodluyoruz;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Restaurant
{
    static Semaphore sem;
    static List<String> ordersToTake;
    static List<String> ordersToCook;
    static List<String> ordersToServe;

    List<Customer> currentCustomers;

    ExecutorService customerPool = Executors.newFixedThreadPool(5);
    ExecutorService waiterPool = Executors.newFixedThreadPool(3);
    ExecutorService cookPool = Executors.newFixedThreadPool(2);


    public static void newOrder(String customerName)
    {
        ordersToTake.add(customerName);
    }
    public static void takeOrder(String customerName)
    {
        ordersToCook.add(customerName);
        ordersToTake.remove(customerName);
    }
    public static void cookOrder(String customerName)
    {
        ordersToServe.add(customerName);
        ordersToCook.remove(customerName);
    }

    Restaurant()
    {

    }
}
