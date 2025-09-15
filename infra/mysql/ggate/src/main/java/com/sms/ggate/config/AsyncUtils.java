package com.sms.ggate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

/**
 * AsyncUtils 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-14
 */
@Service
public class AsyncUtils {

    private final Executor executors;

    public AsyncUtils(@Qualifier("asyncExecutor") Executor executors) {
        this.executors = executors;
    }

    public <T, R> List<R> runAsyncAdnCollect(
            List<T> list,
            Function<T, R> mapper
    ) {
        List<CompletableFuture<R>> futures = list.stream()
                .map(item -> CompletableFuture.supplyAsync(() -> mapper.apply(item), executors))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return futures.stream()
                .map(CompletableFuture::join)
                .toList();
    }
}
