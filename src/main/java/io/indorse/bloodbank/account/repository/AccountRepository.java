package io.indorse.bloodbank.account.repository;

import io.indorse.bloodbank.model.domain.BloodBankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<BloodBankAccount,Long> {
    public BloodBankAccount findByUuid(String uuid);
}
