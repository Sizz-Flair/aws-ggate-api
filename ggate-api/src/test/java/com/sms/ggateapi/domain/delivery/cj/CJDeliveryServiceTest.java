package com.sms.ggateapi.domain.delivery.cj;

import org.giant.api.domain.delivery.logen.LogenApiFacade;
import org.giant.api.domain.delivery.logen.LogenUserInfoDto;
import org.giant.api.domain.delivery.logen.zip.LogenZipCodeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CJDeliveryServiceTest {


    @Autowired
    CJDeliveryService  cjDeliveryService;

    @Autowired
    LogenApiFacade logenApiFacade;

    @Test
    void test() {
        String orderNo = cjDeliveryService.getZipCode("orderNo", "서울특별시 성동구 행당로 82 (행당 한진타운) 202동 2208호");
//        LogenUserInfoDto userInfo = LogenUserInfoDto.builder()
//                .userId("37856104")
//                .passWord("1q2w3e4r!")
//                .build();
//        LogenZipCodeDto logenZipCodeDto = logenApiFacade.callZipCode(userInfo, "서울특별시 성동구 행당로 82 (행당 한진타운) 202동 2208호");

        System.out.println("orderNo");
    }
}