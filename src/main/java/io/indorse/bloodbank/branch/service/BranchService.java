package io.indorse.bloodbank.branch.service;

import io.indorse.bloodbank.model.domain.BloodBankBranch;

public interface BranchService {
    /**
     * Create new branch
     * @param branch Holds the branch entity instance
     * @return Primary Key uniquely identifies the record
     */
    public Long create(BloodBankBranch branch);

    /**
     * Find the Branch
     * @param uuid Uniquely identifies the Branch
     * @return Branch matching the UUID
     */
    public BloodBankBranch findByUUID(String uuid);

    /**
     * Find All Branches
     * @return List of branches.
     */
    public Iterable<BloodBankBranch> findAll();
}
