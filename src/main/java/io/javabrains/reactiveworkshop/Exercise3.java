package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size

        //Blocking code
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());

        //after all the items are collected,it will take 9-10 seconds,then only below code will be executed
        System.out.println("List is " + numbers);
        System.out.println("Size is : " + numbers.size());
    }

}
