package com.sms.ggate.domain.agent.service;

import com.example.jooq.generated.tables.pojos.GAgentPojo;
import com.sms.ggate.domain.agent.repository.AgentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GAgentService {

    private final AgentRepository repo;
    public Map<String, GAgentPojo> agentMap;

    @PostConstruct
    private void cacheAgent() {
        List<GAgentPojo> allGAgent = repo.findAllGAgent();
        agentMap = allGAgent
                .stream()
                .collect(Collectors.toMap(
                        GAgentPojo::agentName,
                        e -> e,
                        (e1, e2) -> e1)
                );
    }

    public GAgentPojo getAgent(String agentName) {
        return agentMap.get(agentName);
    }
}
