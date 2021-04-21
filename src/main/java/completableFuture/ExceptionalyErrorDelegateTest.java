package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ExceptionalyErrorDelegateTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            if (true)
                throw new NullPointerException("throw illegal exp from level 2");
            return "ok";
        }).exceptionally(t -> {
            System.out.println("hello error level 1"+ t.getCause());
            if (unwrapCompletionException(t) instanceof IllegalArgumentException) {
                return "i ok, please proceed";
            } else {
                throw new RuntimeException(t);
            }
        }).thenApply(x -> {
            System.out.println("receive response " + x);
            return "im ok, we complete our process";
        }).exceptionally(t -> {
            System.out.println("error " + t.getMessage());
            return "complete with error here";
        });


        System.out.println(welcomeText.get());
    }

    private static Throwable unwrapCompletionException(Throwable t) {
        if (t instanceof CompletionException) {
            return t.getCause();
        }
        return t;
    }


}
