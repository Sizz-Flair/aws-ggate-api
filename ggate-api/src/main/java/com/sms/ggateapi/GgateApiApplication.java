package com.sms.ggateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * Ggate api application 클래스.
 * * <p>역할:
 * * <p>상속: PsiClass:Object
 * * @author YourName
 *
 * @since 2025 -09-07
 */
@SpringBootApplication(scanBasePackages = {
        "com.sms.ggate",
        "com.sms.ggateapi"
})
@EnableAsync
public class GgateApiApplication {
    /**
     * <메소드의 목적을 짧게 설명합니다.> * * * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(GgateApiApplication.class, args);
    }
}
