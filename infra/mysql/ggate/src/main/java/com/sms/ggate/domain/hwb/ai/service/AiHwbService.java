package com.sms.ggate.domain.hwb.ai.service;

import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;
import com.sms.ggate.domain.hwb.ai.repository.AiHwbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AiHwbService {

    private final AiHwbRepository repository;

    @Transactional
    public void saveBatch(List<TmAiHwbPojo> tmAiHwbList) {
        repository.saveBatch(tmAiHwbList);
    }
}
