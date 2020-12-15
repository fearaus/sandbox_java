package udemy.functional;

public class LambdaExample1 {


    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();

        Thread t1 = new Thread(()-> System.out.println("hello world"));
        t1.run();
        System.out.println(Thread.currentThread().getName());
    }
}
