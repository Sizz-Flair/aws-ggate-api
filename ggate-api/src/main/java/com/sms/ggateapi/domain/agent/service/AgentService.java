package com.sms.ggateapi.domain.agent.service;

import com.example.jooq.generated.tables.pojos.GAgentPojo;
import com.sms.ggate.domain.agent.service.GAgentService;
import com.sms.ggateapi.domain.agent.mapper.AgentMapper;
import com.sms.ggateapi.domain.agent.model.Agent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final GAgentService gAgentService;

    public Agent getAgent(final String name) {
        GAgentPojo gAgentPojo = gAgentService.getAgent(name);

        return AgentMapper.toDomain(gAgentPojo);
    }
}