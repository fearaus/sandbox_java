package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class test1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Firdaus";
        }).thenApply(name -> {
            throw new NullPointerException("test error");
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the Completeable future";
        }).thenApply(u->extractName(u));

        System.out.println(welcomeText.get());
    }

    public static String extractName(String name) {
        return name + " append";

    }


}
