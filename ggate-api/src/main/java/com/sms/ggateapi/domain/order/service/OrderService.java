package com.sms.ggateapi.domain.order.service;

import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.sms.ggate.domain.hwb.ai.service.AiHwbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final AiHwbService aiHwbService;

    public void saveALl(List<TmAiHwbPojo> tmAiHwbs) {
        aiHwbService.saveBatch(tmAiHwbs);
    }
}
