package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class ExceptionallyCallback {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer age = -1;

        try {
            CompletableFuture
                    .runAsync(() -> method1(age))
                    .handle((res,ex) -> {
                        System.out.println("Oops! We have an exception - " + ex.getMessage());
                        return null;
                    }).join();
        } catch (Exception ex) {

            System.out.println("outer try ==>" + ex.getMessage());
        }

        // System.out.println("Maturity : " + maturityFuture.get());
    }


    public static CompletionStage<String> method1(int age) {
        return CompletableFuture.supplyAsync(() -> method2(age)).whenComplete((res, ex) -> {
            if (ex != null) {
                System.out.println(ex.getClass() + " info  => " + ex.getMessage());
            }
        });
    }

    public static String method2(int age) {
        if (age < 0) {
            throw new RuntimeException("Age can not be negative");
        }
        if (age > 18) {
            return "Adult";
        } else {
            return "Child";
        }
    }
}
