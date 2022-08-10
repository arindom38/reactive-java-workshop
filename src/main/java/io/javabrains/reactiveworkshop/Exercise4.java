package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        /*Mono VS FLUX
         *
         * Mono: return 0 or 1 times
         * Flux: return 0 or n times
         *
         * What's coming from a Mono or Flux Source?
         * 1. An item
         * 2. A complete Event / A failure Event (Terminal events)
         *
         * Main Difference between mono and flux:
         *
         * When an item or 0 item comes in MONO , no other items come after that , only a terminal events executed and mono is completed
         * In FLUX, there can be multiple items , but when items finished without ant error a complete event executed , else a failtu
         *
         * */

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
