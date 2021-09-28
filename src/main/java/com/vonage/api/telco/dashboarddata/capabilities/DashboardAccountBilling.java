package com.vonage.api.telco.dashboarddata.capabilities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.MappedProperty;

@Introspected
public class DashboardAccountBilling {

    private String accountRef;

    public String getAccountRef() {
        return accountRef;
    }

    public void setAccountRef(String accountRef) {
        this.accountRef = accountRef;
    }
}
