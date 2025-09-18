package com.sms.ggate.domain.hwb.ai.repository;

import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.example.jooq.generated.tables.records.TmAiHwbRecord;
import com.sms.ggate.domain.BaseRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jooq.generated.tables.TmAiHwb.TM_AI_HWB;

@Repository
public class AiHwbRepository extends BaseRepository<TmAiHwbRecord> {
    protected AiHwbRepository(DSLContext dsl) {
        super(dsl, TM_AI_HWB);
    }

    public void saveOne(TmAiHwbPojo tmAiHwb) {
        TmAiHwbRecord record = dsl.newRecord(TM_AI_HWB, tmAiHwb);
        record.store();
    }

    /**
     * mariadb 버전 문제로 insert 시 store 사용 안됨(returning 지원 안함)
     *
     * @param tmAiHwb
     * @return
     */
    public TmAiHwbPojo saveOneOrReturn(TmAiHwbPojo tmAiHwb) {
        TmAiHwbRecord record = dsl.newRecord(TM_AI_HWB, tmAiHwb);

        dsl.executeInsert(record);

        return record.into(TmAiHwbPojo.class);
    }

    /**
     * MariaDB Returnning v10.5부터 지원하여 저장 후 다시 조회 방식으로
     * @param tmAiHwbList
     */
    public List<TmAiHwbPojo> saveBatchAndReturn(final List<TmAiHwbPojo> tmAiHwbList) {
        List<TmAiHwbRecord> records = tmAiHwbList.stream()
                .map(v -> dsl.newRecord(TM_AI_HWB, v))
                .toList();

        dsl.batchInsert(records)
                .execute();

        List<String> list = records.stream().map(TmAiHwbRecord::getHwbNo).toList();

        return dsl.selectFrom(TM_AI_HWB)
                .where(TM_AI_HWB.HWB_NO.in(list))
                .fetchInto(TmAiHwbPojo.class);
    }
}
