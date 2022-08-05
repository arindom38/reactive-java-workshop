package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream

        //Publisher is Flux
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();

        /*The ordering of execution in not predictable
         * Here each element is treated individually no as list of items
         * */
        stream.subscribe(num -> System.out.println(num));
        stream.subscribe(num -> System.out.println("Another one :" + num));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
