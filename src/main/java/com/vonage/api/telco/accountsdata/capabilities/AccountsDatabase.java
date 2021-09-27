package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.GenericRepository;

import java.util.List;

@JdbcRepository
public interface AccountsDatabase extends GenericRepository<Account, String> {

    @Query(value = "SELECT sysId FROM config.account WHERE capabilities LIKE '%-random%' OR accountRandomPoolsEnabled = 1",
            nativeQuery = true)
    List<Account> accountsWithAccountRandomPools();

    @Query(value = "SELECT sysId FROM config.account WHERE capabilities LIKE '%queue-throttled-mt%' OR capabilities LIKE '%sub-control-queue%'",
            nativeQuery = true)
    List<Account> accountsWithSubmissionControlEnabled();

    @Query(value = "SELECT sysId FROM config.account WHERE smppEnabled = 1",
            nativeQuery = true)
    List<Account> accountsWithSmppEnabled();
}