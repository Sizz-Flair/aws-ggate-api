package com.sms.ggate.domain.doc.repository;

import com.example.jooq.generated.tables.records.GDocNoCjRecord;
import com.sms.ggate.domain.BaseRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static com.example.jooq.generated.tables.GDocNoCj.G_DOC_NO_CJ;

/**
 * Doc no cj repository 클래스.
 * * <p>역할:
 * * <p>상속: PsiClass:BaseRepository
 * * @author YourName
 *
 * @since 2025 -09-07
 */
@Repository
public class DocNoCJRepository extends BaseRepository<GDocNoCjRecord> {

    /**
     * Instantiates a new Doc no cj repository.
     *
     * @param dsl the dsl
     */
    protected DocNoCJRepository(DSLContext dsl) {
        super(dsl, G_DOC_NO_CJ);
    }

    /**
     * CJ 번호를 하나 조회하여 반환
     * <p>이 메서드는 {@code ASSIGNED = 'N'}인 행 중에서 {@code ID} 오름차순으로
     * 가장 앞선 행을 {@code FOR UPDATE SKIP LOCKED}로 배타 잠금을 걸어 조회합니다.
     * 이미 다른 트랜잭션에서 잠근 행은 건너뛰며, 조회 결과는 최대 1건입니다.
     * </p>
     *
     * @return 조회된 행의 CJ번호
     * @throws NoSuchElementException 할당 가능한 행이 존재하지 않을 경우
     */
    @Transactional
    public String getCJInvoiceNumber() {
        return dsl.selectFrom(G_DOC_NO_CJ)
                .where(G_DOC_NO_CJ.ASSIGNED.eq("N"))
                .orderBy(G_DOC_NO_CJ.ID.asc())
                .limit(1)
                .forUpdate()
                .skipLocked()
                .fetchOptional(G_DOC_NO_CJ.HWB_NO)
                .orElseThrow(NoSuchElementException::new);
    }
}
