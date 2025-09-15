package com.sms.ggate.domain.agent.service;

import com.example.jooq.generated.tables.GAgent;
import com.example.jooq.generated.tables.pojos.GAgentPojo;
import com.sms.ggate.domain.agent.repository.AgentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository repo;
    public static Map<String, GAgent> agentMap;

    @PostConstruct
    private void cacheAgent() {
        List<GAgentPojo> allGAgent = repo.findAllGAgent();
    }

}
