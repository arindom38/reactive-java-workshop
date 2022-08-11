package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

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
        System.out.println("-------Controlling backpressure with subscription classes------");
        ReactiveSources.intNumbersFlux()
                .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    //write code that needed when a subscription happens
    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("You are subscribed!!");
        /*
         * Controlling Backpressure:
         *This method will be executed only when subscription happens
         * if you don't ask for more inside hookOnNext() it will to  handle further requests/
         * This request method tell the stream that it can handle n request at a time whenever they are READY, but it is not pulling
         * */
        request(2);
    }

    //Hook for handling requested item
    @Override
    public void hookOnNext(T value) {
        System.out.println(value.toString() + " is received! ");

        /*
         * Controlling Backpressure:
         *
         * This method request for more when request are ready
         * if this method is not included in side hookOnNext , the subscribe method only get given number of item
         * that  is mentioned on the hookOnSubscribe() > request() method
         * */
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        super.hookOnComplete();
    }

}