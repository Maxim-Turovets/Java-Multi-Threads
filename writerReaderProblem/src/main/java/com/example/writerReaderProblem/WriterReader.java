package com.example.writerReaderProblem;


import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@SpringBootApplication
public class WriterReader {

	static Semaphore readLock = new Semaphore(1);
	static Semaphore writeLock = new Semaphore(1);
	static volatile int readCount = 0;
	

	public static void main(String[] args) throws Exception {
		Read read = new Read(readLock,writeLock,readCount);
		Write write = new Write(readLock,writeLock);
		Thread t1 = new Thread(read);
		t1.setName("thread1");
		Thread t2 = new Thread(read);
		t2.setName("thread2");
		Thread t3 = new Thread(write);
		t3.setName("thread2");
		Thread t4 = new Thread(read);
		t4.setName("thread4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
