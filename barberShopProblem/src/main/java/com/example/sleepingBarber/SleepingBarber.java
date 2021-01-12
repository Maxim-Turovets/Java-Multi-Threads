package com.example.sleepingBarber;


import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@SpringBootApplication
public class SleepingBarber {

	public static void main(String args[]) {
		Bshop shop = new Bshop();

		Barber barber = new Barber(shop);
		CustomerGenerator cg = new CustomerGenerator(shop);

		Thread thbarber = new Thread(barber);
		Thread thcg = new Thread(cg);
		thcg.start();
		thbarber.start();
	}
}







