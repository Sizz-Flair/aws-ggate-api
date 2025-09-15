package com.sms.ggate.domain.agent.repository;

import com.example.jooq.generated.tables.pojos.GAgentPojo;
import com.example.jooq.generated.tables.records.GAgentRecord;
import com.sms.ggate.domain.BaseRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.jooq.generated.tables.GAgent.G_AGENT;

@Repository
public class AgentRepository extends BaseRepository<GAgentRecord> {
    protected AgentRepository(DSLContext dsl) {
        super(dsl, G_AGENT);
    }

    public Optional<GAgentPojo> findById(Long id) {
        return dsl.selectFrom(G_AGENT)
                .where(G_AGENT.ID.eq(id))
                .fetchOptionalInto(GAgentPojo.class);
    }

    public List<GAgentPojo> findAllGAgent() {
        return dsl.selectFrom(G_AGENT)
                .fetchInto(GAgentPojo.class);
    }
}
