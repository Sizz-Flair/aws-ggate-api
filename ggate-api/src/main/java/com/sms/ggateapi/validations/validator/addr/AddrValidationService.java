package com.sms.ggateapi.validations.validator.addr;

/**
 * AddrValidationService 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-08
 */
public interface AddrValidationService {
    String valid(String address, String deliveryCode);
}
