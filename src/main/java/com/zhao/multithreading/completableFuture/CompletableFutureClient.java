package com.zhao.multithreading.completableFuture;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 17:43
 **/
public class CompletableFutureClient {

    private static ExecutorService service = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));
    static volatile int i ;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testThenCompose(Arrays.asList(1,2,3,4,50));
    }

    /**
     * 执行没有返回结果
     */
    static void testRunAsync() {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0 ; i < 1000 ; i ++) {
            integers.add(i + 1);
        }
        for (; i < 1000 ; i ++) {
            CompletableFuture.runAsync(() -> System.out.println(i),service);
        }
        CompletableFuture.runAsync(() -> {
            integers.forEach(a -> System.out.println(a));
        },service);
    }

    /**
     * 执行有返回结果的
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void testSupplyAsync() throws ExecutionException, InterruptedException {
        for(; i < 1000 ; i ++) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println(i);
                return i;
            },service);
        }


    }

    /**
     * 执行完之后，不过有没有错误，都执行when，
     * whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
     * whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
     *
     */
    static void testWhenFun() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 0).whenComplete((v,action) -> System.out.println("错误"));
    }

    /**
     * 当发生错误后才执行
     */
    static void testExceptionally() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1/0).exceptionally((t) -> {
            System.out.println("错误了");
            return 0;
        });
    }

    /**
     * 当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化。thenApplyAsync当执行完后，把它交给线程池来处理
     * 当发生错误时，thenApply发放不执行
     */
    static void testThenApply() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1/0).thenApplyAsync(a -> {
            System.out.println(a);
            return a + 100;
        });
    }

    /**
     * handle 是执行任务完成时对结果的处理。
     * handle 方法和 thenApply 方法处理方式基本一样。不同的是 handle 是在任务完成后再执行，还可以处理异常的任务。
     * thenApply 只可以执行正常的任务，任务出现异常则不执行 thenApply 方法。
     * 可以根据Throwable来判断是否出现异常
     */
    static void testHandle() {
        CompletableFuture<Integer> handle = CompletableFuture.supplyAsync(() -> 10).handle((aint,berror) -> {
            if (berror != null) {
                System.out.println(berror.toString());
            } else {
                System.out.println(aint);
            }
            return 0;
        });
    }

    /**
     * thenAccept 消费处理结果
     * 接收任务的处理结果，并消费处理，无返回结果。
     * 方法只是消费执行完成的任务，并可以根据上面的任务返回的结果进行处理。并没有后续的输错操作。
     */
    static void testThenAccept() {
        CompletableFuture<Void> handle = CompletableFuture.supplyAsync(() -> String.valueOf(10/0)).thenAccept(a -> System.out.println(a));
    }

    /**
     * 跟 thenAccept 方法不一样的是，不关心任务的处理结果。
     * 只要上面任务执行完，就执行这个，这个方法没参数，当出现异常时不执行。
     * 上个任务处理完成后，并不会把计算的结果传给 thenRun 方法。
     */
    static void testThenRun() {
        CompletableFuture<Void> handle = CompletableFuture.supplyAsync(() -> String.valueOf(10)).thenRun(() -> System.out.println("你好"));
    }

    /**
     * thenCombine 合并发放
     * thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
     */
    static void testThenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "臭小子");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "打你屁股");
        CompletableFuture<String> future = future1.thenCombine(future2,(t1,t2) -> t1 + "," + t2);
        System.out.println(future.get());
    }

    /**
     * 当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
     */
    static void testThenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "臭小子");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "打你屁股");
        CompletableFuture<Void> future = future1.thenAcceptBoth(future2,(f1,f2) -> System.out.println(f1 + " ," + f2));
        future.get();
    }

    /**
     * 两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的转化操作。
     */
    static void testApplyToEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        future1.applyToEither(future2, f1 ->{
            System.out.println(f1);
            return 0;
        });
    }

    /**
     * 两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的消耗操作。
     */
    static void testAcceptEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        future1.acceptEither(future2, f1 ->{
            System.out.println(f1);
        });
    }

    /**
     * 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）
     */
    static void testRunAfterEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println("我先执行了，哈哈");
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
                System.out.println("我后执行了，哈哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        future1.runAfterEitherAsync(future2, () -> System.out.println("任何方法执行完后都会执行它") , service);
    }

    /**
     * 两个CompletionStage，都完成了计算才会执行下一步的操作（Runnable）
     */
    static void testRunAfterBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println("我先执行了，哈哈");
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
                System.out.println("我后执行了，哈哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        CompletableFuture<Void> future = future1.runAfterBoth(future2,() -> {
            System.out.println("两者执行完了才执行我");
        });
        future.get();
    }

    /**
     * thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作。
     */
    static void testThenCompose(List<Integer> list) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> test = new ArrayList<>();
        list.stream().forEach(a -> {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println(a + 5);
                return a + 5;
            },service).thenCompose(b -> {
                return CompletableFuture.supplyAsync(() ->{
                            System.out.println(b);
                    return b + 10;
                    }
                 ,service);
            });
            test.add(future);
        });
        for(CompletableFuture<Integer> t: test) {
            System.out.println(t.get());
        }

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10).thenCompose(a -> {
//            System.out.println(a * 100);
//            return CompletableFuture.supplyAsync(() -> a);
//        });
    }

}
