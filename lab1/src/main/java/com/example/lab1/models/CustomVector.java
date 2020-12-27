package com.example.lab1.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomVector {
    private List<Integer> numbers;

    public CustomVector(int quantity){
        this.numbers = new ArrayList<>();
        generateNumbers(quantity);
    }
    private void generateNumbers(int quantity){
        for (int i = 0; i <quantity; i++) {
            numbers.add((int)((Math.random()*100)));
        }
    }


    public CustomVector(List<Integer> numbers){
        this.numbers = numbers;
    }
    public void print(){
        System.out.print("[ ");
        this.numbers.forEach(el -> System.out.print(el + ", "));
        System.out.print("]");
        System.out.println();
    }
}
