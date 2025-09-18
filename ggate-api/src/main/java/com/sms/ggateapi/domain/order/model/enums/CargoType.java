package com.sms.ggateapi.domain.order.model.enums;

public enum CargoType {
    IMPORT("I"),
    IMPORT_TRANSSHIPMENT("T"),
    EXPORT("E"),
    EXPORT_TRANSSHIPMENT("R");

    private String value;

    CargoType(String value) {
        this.value = value;
    }

    public String getType() {
        return value;
    }
}
