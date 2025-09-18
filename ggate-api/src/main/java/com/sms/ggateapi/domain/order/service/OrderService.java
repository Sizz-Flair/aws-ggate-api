package com.sms.ggateapi.domain.order.service;

import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.sms.ggate.domain.hwb.ai.service.AiHwbService;
import com.sms.ggateapi.domain.agent.model.Agent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final AiHwbService aiHwbService;

    public List<TmAiHwbPojo> saveBatchAndReturn(List<TmAiHwbPojo> tmAiHwbs) {
        return aiHwbService.saveBatchAndReturn(tmAiHwbs);
    }

    public String createMappingNo(Agent agent) {
        String sysdate = new SimpleDateFormat("yyMMddHH").format(new Timestamp(System.currentTimeMillis()));
        return "api_" + agent.agentCode().toLowerCase() + "_" + sysdate;
    }
}
