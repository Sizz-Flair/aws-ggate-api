package com.sms.ggateapi.validations.validator.addr;

import com.sms.ggateapi.domain.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AddressValidator implements AddrValidationService {

    private final Map<String, DeliveryService> deliveryService;

    @Override
    public String valid(String address, String deliveryCode) {
        return "";
    }
}
