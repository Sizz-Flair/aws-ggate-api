package com.sms.ggate.domain.hwb.ai.service;

import com.builder.TmAiHwbBuilder;
import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.example.jooq.generated.tables.records.TmAiHwbRecord;
import org.jooq.DSLContext;
import org.jooq.exception.DataChangedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.jooq.generated.tables.TmAiHwb.TM_AI_HWB;

@SpringBootTest
class AIHwbServiceTest {


    @Autowired
    private DSLContext dsl;

    @Autowired
    private AiHwbService aiHwbService;

    @Test
    void 낙관적_락_테스트() {
        TmAiHwbRecord tmAiHwbRecord = dsl.selectFrom(TM_AI_HWB).where(TM_AI_HWB.HWB_NO.eq("315835116354_T4")).fetchOne();

        tmAiHwbRecord.setHwbNo("315835116354_T5");

        try {
               tmAiHwbRecord.store();
        } catch (DataChangedException e) {
            tmAiHwbRecord = dsl.selectFrom(TM_AI_HWB).where(TM_AI_HWB.HWB_NO.eq("315835116365")).fetchOne();
            tmAiHwbRecord.setHwbNo("315835116365_T");
            tmAiHwbRecord.store();
        }
    }
    @Test
    @Transactional
    //다른 rock은 대기 noWait() 를 줘야 안기다림 또는 skipLocked
    void 배타_락() {
        TmAiHwbRecord tmAiHwbRecord = dsl.selectFrom(TM_AI_HWB).where(TM_AI_HWB.HWB_NO.eq("315835116354_T5")).forUpdate().fetchOne();


        tmAiHwbRecord.setHwbNo("315835116354_T6");

        tmAiHwbRecord.store();
    }

    @Test
    void 배치테스트() {
        List<TmAiHwbPojo> batch = new ArrayList<>();
        long l = System.currentTimeMillis();
        for(int i=0; i<20000; i++) {
            batch.add(TmAiHwbBuilder.Builder()
                    .hwbNo("50000111111"+i + "Test")
                    .orderNo("orderNo")
                    .orderDt(LocalDateTime.now())
                    .agentId(1L)
                    .mappingNo("mappingNo")
                    .deliveryCode("CJ")
                    .build());

            if(batch.size() % 1000 == 0) {
                aiHwbService.saveBatchAndReturn(batch);
                batch.clear();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("소요시간 : " + (end - l) / 1_000_000_000.0 + "초");
    }
}