package com.example.lab1;


import com.example.lab1.MVC.Controller;
import com.example.lab1.MVC.Model;
import com.example.lab1.MVC.View;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

		controller.processUser();
	}

}
