package com.vonage.api.telco.dashboarddata.capabilities;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.annotation.RepositoryConfiguration;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.runtime.context.env.ConfigurationAdvice;

import java.util.List;

@JdbcRepository
@Repository("dashboard")
public interface DashboardDatabase extends GenericRepository<DashboardAccountBilling, String> {

    @Query(value = "SELECT account_ref FROM dashboard.d_account_billing WHERE type_id = 5",
            nativeQuery = true)
    List<DashboardAccountBilling> prepaidAccounts();

}
