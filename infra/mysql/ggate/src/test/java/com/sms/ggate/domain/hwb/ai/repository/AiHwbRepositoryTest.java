package com.sms.ggate.domain.hwb.ai.repository;


import com.builder.TmAiHwbBuilder;
import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * AiHwbRepositoryTest 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-14
 */
@SpringBootTest
class AiHwbRepositoryTest {

    @Autowired
    AiHwbRepository repository;

//    @Test
//    void save() {
//        TmAiHwbPojo build = TmAiHwbBuilder.Builder()
//                .hwbNo("500001111111")
//                .orderNo("orderNo")
//                .orderDt(LocalDateTime.now())
//                .agentId(1L)
//                .mappingNo("mappingNo")
//                .deliveryCode("CJ")
//                .build();
//
//        repository.saveOneOrReturn(build);
//    }
}