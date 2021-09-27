package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.MappedProperty;

@Introspected
public class Account {

    @MappedProperty("sysId")
    private String sysId;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
}
