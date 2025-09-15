package com.sms.ggate.domain.doc.service;

import com.sms.ggate.domain.doc.repository.DocNoCJRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("docNoCJService")
@RequiredArgsConstructor
public class DocNoCJService {

    private final DocNoCJRepository repo;

    public String getInvoiceNumber() {
        return repo.getCJInvoiceNumber();
    }

}
