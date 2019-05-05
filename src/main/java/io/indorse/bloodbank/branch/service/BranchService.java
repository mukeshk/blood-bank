package io.indorse.bloodbank.branch.service;

import io.indorse.bloodbank.model.domain.BloodBankBranch;

public interface BranchService {
    public Long create(BloodBankBranch branch);
    public BloodBankBranch findByUUID(String uuid);
    public Iterable<BloodBankBranch> findAll();
}
