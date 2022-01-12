package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.MappedProperty;

@Introspected
public class AccountWithMtLimit extends Account {

    @MappedProperty("maxMtPerSecond")
    private Long maxMt;

    public Long getMaxMt() {
        return maxMt;
    }

    public void setMaxMt(Long maxMt) {
        this.maxMt = maxMt;
    }
}
