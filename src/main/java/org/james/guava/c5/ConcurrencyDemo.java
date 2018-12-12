package org.james.guava.c5;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ConcurrencyDemo {

  public static void main(String... args) {
    final CountDownLatch latch = new CountDownLatch(2);

    ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
        Executors.newCachedThreadPool());
    ListenableFuture<Integer> listenableFuture = executorService.submit(() -> {
      System.out.println("call execute...");
      TimeUnit.SECONDS.sleep(1);
      return 7;
    });

    listenableFuture.addListener((() -> {
      try {
        System.out.println("get result by addListener: " + listenableFuture.get());
        latch.countDown();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }), executorService);

    Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
      @Override
      public void onSuccess(@Nullable Integer result) {
        System.out.println("get result by addCallback: " + result);
        latch.countDown();
      }

      @Override
      public void onFailure(Throwable t) {
        System.out.println("failure");
        latch.countDown();
      }
    }, executorService);

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    executorService.shutdown();

  }

}
