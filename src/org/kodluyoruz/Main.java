package org.kodluyoruz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)
    {

        Restaurant newRestaurant = new Restaurant();

        for(int i=0; i<5;i++)
        {
            Customer newCustomerFromStreet = new Customer(newRestaurant.sem,String.valueOf(i));
            newRestaurant.customerPool.execute(newCustomerFromStreet);
        }

        Waiter waiter1 = new Waiter(newRestaurant.sem,"waiter1");
        Waiter waiter2 = new Waiter(newRestaurant.sem,"waiter2");
        Waiter waiter3 = new Waiter(newRestaurant.sem,"waiter3");

        Cook cook1 = new Cook(newRestaurant.sem,"cook1");
        Cook cook2 = new Cook(newRestaurant.sem,"cook2");

        newRestaurant.waiterPool.execute(waiter1);
        newRestaurant.waiterPool.execute(waiter2);
        newRestaurant.waiterPool.execute(waiter3);

        newRestaurant.cookPool.execute(cook1);
        newRestaurant.cookPool.execute(cook2);

        ExecutorService customerPool = Executors.newFixedThreadPool(5);


    }
}
