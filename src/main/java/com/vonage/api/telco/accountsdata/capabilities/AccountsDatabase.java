package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.GenericRepository;

import java.util.List;

@JdbcRepository
@Repository("config")
public interface AccountsDatabase extends GenericRepository<Account, String> {

    @Query(value = "SELECT sysId FROM config.account WHERE smppEnabled = 1",
            nativeQuery = true)
    List<Account> accountsWithSmppEnabled();

    @Query(value = "SELECT sysId FROM config.account WHERE (masterAccountUseMasterQuota = 1 AND masterAccountId = :sysId) OR sysId = :sysId",
            nativeQuery = true)
    List<Account> quotaAccountsFor(String sysId);
}
