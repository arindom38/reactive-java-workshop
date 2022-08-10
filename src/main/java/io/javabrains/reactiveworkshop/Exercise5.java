package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(
                num -> System.out.println(num), //consumer for item
                err -> System.out.println(err.getMessage()), // Consumer for error event
                () -> System.out.println("Mono Completed") // consumer for complete event
        );

        ReactiveSources.intNumbersFlux().subscribe(
                num -> System.out.println(num), //consumer for item
                err -> System.out.println(err.getMessage()), // Consumer for error event
                () -> System.out.println("Mono Completed") // consumer for complete event
        );

        ReactiveSources.userMono().subscribe(
                user -> System.out.println(user), //consumer for item
                err -> System.out.println(err.getMessage()), // Consumer for error event
                () -> System.out.println("Mono Completed") // consumer for complete event
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}