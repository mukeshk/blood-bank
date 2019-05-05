package io.indorse.bloodbank.branch.mapper;

import io.indorse.bloodbank.common.mapper.AddressMapper;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.BloodBankBranchDTO;

public class BranchMapper {

    public static BloodBankBranch mapNewInstance(BloodBankBranchDTO branchDTO){
        BloodBankBranch branch = new BloodBankBranch();
        branch.setContactEmail(branchDTO.getContactEmail());
        branch.setContactNumber(branchDTO.getContactNumber());
        branch.setManager(branchDTO.getManager());
        branch.setBranchName(branchDTO.getBranchName());
        branch.setAddress(AddressMapper.map(branchDTO.getAddress()));
        return branch;
    }

    public static BloodBankBranchDTO map(BloodBankBranch branch){
        BloodBankBranchDTO branchDTO = new BloodBankBranchDTO();
        branchDTO.setContactEmail(branch.getContactEmail());
        branchDTO.setContactNumber(branch.getContactNumber());
        branchDTO.setManager(branch.getManager());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setAddress(AddressMapper.map(branch.getAddress()));
        branchDTO.setUuid(branch.getUuid());
        return branchDTO;
    }
}