package com.example.lab1;

import com.example.lab1.models.CustomVector;
import com.example.lab1.services.CalculateVectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {

		CustomVector customVector = new CustomVector(100000000);
		CustomVector customVector2 = new CustomVector(100000000);

		// TODO Print vectors
		//customVector.print();
		//customVector2.print();

		CalculateVectors calculateVectors = new CalculateVectors();

		long startTime = System.currentTimeMillis();
		calculateVectors.calculateSum(customVector,customVector2);
		long notThreadTime =  System.currentTimeMillis() - startTime;
		System.out.println("One Thread methods time : ["+ notThreadTime+"] ms");

		long startTimeThreadsMethod = System.currentTimeMillis();
		calculateVectors.calculateSumThreads(customVector,customVector2,5);
		long threadsTime =  System.currentTimeMillis() - startTimeThreadsMethod;
		System.out.println("Multi Threads methods time : ["+ threadsTime+"] ms");
	}

}
