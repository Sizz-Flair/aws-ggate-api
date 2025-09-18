package com.sms.ggateapi.domain.agent.model;

public record Agent(
        Long id,
        String name,
        String key,
        String secure,
        String agentCode,
        String agentTel,
        String agentZip,
        String agentAddress
) {
    public static Agent of(Long id, String name, String key, String secure, String agentCode, String agentTel, String agentZip, String agentAddress) {
        return new Agent(id, name, key, secure, agentCode, agentTel, agentZip, agentAddress);
    }
}
