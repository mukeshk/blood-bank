package io.indorse.bloodbank.account.service;

import io.indorse.bloodbank.model.domain.BloodBankAccount;

import java.util.List;

public interface AccountService {
    public Long create(BloodBankAccount account);
    public BloodBankAccount findByUUID(String uuid);
    public Iterable<BloodBankAccount> findAll();
}
