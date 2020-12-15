package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionallyHandle {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if(ex != null) {

                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }

            if(age < 0) {
                //throw new IllegalArgumentException("Age can not be negative");
            }
            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }
}
