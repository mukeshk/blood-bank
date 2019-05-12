package io.indorse.bloodbank.branch.mapper;

import io.indorse.bloodbank.common.mapper.AddressMapper;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.BloodBankBranchDTO;
import io.indorse.bloodbank.model.dto.BloodBankBranchListDTO;

public class BranchMapper {

    /**
     * Map Branch model to entity
     * @param branchDTO Holds the branch details.
     * @return Branch entity instance
     */
    public static BloodBankBranch mapNewInstance(BloodBankBranchDTO branchDTO){
        BloodBankBranch branch = new BloodBankBranch();
        branch.setContactEmail(branchDTO.getContactEmail());
        branch.setContactNumber(branchDTO.getContactNumber());
        branch.setManager(branchDTO.getManager());
        branch.setBranchName(branchDTO.getBranchName());
        branch.setAddress(AddressMapper.map(branchDTO.getAddress()));
        return branch;
    }

    /**
     * Map Branch entity to model
     * @param branch Holds the branch entity instance
     * @return Branch model
     */
    public static BloodBankBranchDTO map(BloodBankBranch branch){
        BloodBankBranchDTO branchDTO = new BloodBankBranchDTO();
        branchDTO.setContactEmail(branch.getContactEmail());
        branchDTO.setContactNumber(branch.getContactNumber());
        branchDTO.setManager(branch.getManager());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setAddress(AddressMapper.map(branch.getAddress()));
        return branchDTO;
    }

    /**
     * Map the branch entity to the List model
     * @param branch Holds the branch entity instance
     * @return Holds the Branch List model.
     */
    public static BloodBankBranchListDTO mapToListModel(BloodBankBranch branch){
        BloodBankBranchListDTO branchDTO = new BloodBankBranchListDTO();
        branchDTO.setContactEmail(branch.getContactEmail());
        branchDTO.setContactNumber(branch.getContactNumber());
        branchDTO.setManager(branch.getManager());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setAddress(AddressMapper.map(branch.getAddress()));
        branchDTO.setUuid(branch.getUuid());
        return branchDTO;
    }
}
