package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        //non blocking code
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        // blocking mono
        Integer number = ReactiveSources.intNumberMono().block();
        System.out.println("Number is : " + number);

        User user = ReactiveSources.userMono().block();
        System.out.println("User : " + user);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
