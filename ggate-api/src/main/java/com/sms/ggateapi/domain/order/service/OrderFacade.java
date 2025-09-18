package com.sms.ggateapi.domain.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.sms.ggateapi.domain.agent.model.Agent;
import com.sms.ggateapi.domain.agent.service.AgentService;
import com.sms.ggateapi.domain.order.dto.TestOrderRequest;
import com.sms.ggateapi.domain.order.mapper.OrderMapper;
import com.sms.ggateapi.domain.order.model.Order;
import com.sms.ggateapi.util.AES256Util;
import com.sms.ggateapi.validations.validator.ValidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ValidateFacaed 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-08
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final Gson gson;
    private final AgentService agentService;
    private final OrderService orderService;
    private final ValidateService validateService;

    public Order saveOrder(String id, String key, List<Order> orders) {
        validateService.validateOrThrow(orders);

        /*
        * id == name
        * */
        Agent agent = agentService.getAgent(id);
        String mappingNo = orderService.createMappingNo(agent);

        orderService.saveBatchAndReturn(OrderMapper.toJooqPojos(orders, agent, mappingNo));

        return null;
    }

    public List<Order> testSaveOrder(TestOrderRequest testOrderRequest) {

        Agent agent = agentService.getAgent(testOrderRequest.id());

        String decrypt = new AES256Util(agent.secure()).decrypt(testOrderRequest.datas());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            List<Order> orders = mapper.readValue(decrypt, new TypeReference<List<Order>>() {});
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        log.info(decrypt);

        return null;
    }
}
