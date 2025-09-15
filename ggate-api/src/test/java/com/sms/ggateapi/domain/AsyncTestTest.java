package com.sms.ggateapi.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
class AsyncTestTest {

    @Autowired
    AsyncTest asyncTest;


    @Test
    void test() throws InterruptedException {
        long l = System.nanoTime();
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            futures.add(asyncTest.test(i));
        }

        CompletableFuture<Void> allDone =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allDone.join(); // 블로킹 대기

        // 결과 모으기
        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .toList();
        long l1 = System.nanoTime();

        System.out.println("소요시간" + (l1-l)/1_000_000_000.0);
    }

    @Test
    void address() {
        long l = System.nanoTime();
        List<CompletableFuture<Map<String, String>>> futures = new ArrayList<>();
        for(int i=0; i<100; i++) {
            futures.add(asyncTest.getAddress("order", "인천광역시 부평구 열우물로 90 (십정동 더샵부평센트럴시티) 126동 305호"));
        }

        CompletableFuture<Void> allDone =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allDone.join(); // 블로킹 대기

        long l1 = System.nanoTime();
        System.out.println("소요시간" + (l1-l)/1_000_000_000.0);
    }

}