package com.sms.ggateapi.domain.agent.mapper;

import com.example.jooq.generated.tables.pojos.GAgentPojo;
import com.sms.ggateapi.domain.agent.model.Agent;

public class AgentMapper {


    public static Agent toDomain(final GAgentPojo gAgentPojo) {
        return Agent.of(
                gAgentPojo.id(),
                gAgentPojo.agentName(),
                gAgentPojo.agentKey(),
                gAgentPojo.agentSecure(),
                gAgentPojo.agentCode(),
                gAgentPojo.agentTel(),
                gAgentPojo.agentZip(),
                gAgentPojo.agentAddr()
        );
    }
}
