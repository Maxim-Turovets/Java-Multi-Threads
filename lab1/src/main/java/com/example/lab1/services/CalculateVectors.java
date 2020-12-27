package com.example.lab1.services;

import com.example.lab1.models.CustomVector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalculateVectors {

    public CustomVector calculateSum(CustomVector oneVector,CustomVector twoVector){
        if(oneVector.getNumbers().size() != twoVector.getNumbers().size()){
            throw  new RuntimeException("Size not equals");
        }

        List<Integer> resumeNumbers = new ArrayList<>();

        for (int i = 0; i < oneVector.getNumbers().size(); i++) {
            resumeNumbers.add(oneVector.getNumbers().get(i) + twoVector.getNumbers().get(i));
        }

        return new CustomVector(resumeNumbers);
    }


    public CustomVector calculateSumThreads(CustomVector oneVector,CustomVector twoVector,int countThreads){
        int sizeVectors = oneVector.getNumbers().size();

        if(sizeVectors != twoVector.getNumbers().size()){
            throw  new RuntimeException("Size not equals");
        }
        int step = sizeVectors / countThreads;

        Integer[] resumeNumbers = new Integer[sizeVectors];

        for (int i = 0; i < countThreads; i++) {
            final int nextStep = (i+1) * step;
            final int startIndex = i * step;

            new Thread(()->{
                for (int j = startIndex; j < nextStep; j++) {
                    resumeNumbers[j] = oneVector.getNumbers().get(j) + twoVector.getNumbers().get(j);
                }
            }).start();
        }


        return new CustomVector(Arrays.asList(resumeNumbers));

    }

}
