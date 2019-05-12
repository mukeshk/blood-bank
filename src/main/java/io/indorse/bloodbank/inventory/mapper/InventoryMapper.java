package io.indorse.bloodbank.inventory.mapper;

import io.indorse.bloodbank.common.mapper.AddressMapper;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.dto.InventoryListDTO;

public class InventoryMapper {
    /**
     * Map inventory entity to list model
     * @param inventory Holds the inventory instance
     * @return Inventory list.
     */
    public static InventoryListDTO mapToListDTO(Inventory inventory){
        InventoryListDTO listDTO = new InventoryListDTO();
        listDTO.setBloodGroup(inventory.getBloodGroup());
        listDTO.setBranchAddress(AddressMapper.mapToString(inventory.getBranch().getAddress()));
        listDTO.setExpiryDate(inventory.getExpiryDate());
        listDTO.setInventoryType(inventory.getInventoryType());
        listDTO.setBranchContactEmail(inventory.getBranch().getContactEmail());
        listDTO.setBranchContactNumber(inventory.getBranch().getContactEmail());
        listDTO.setBranchContactName(inventory.getBranch().getManager());
        listDTO.setBranchName(inventory.getBranch().getBranchName());
        return listDTO;
    }
}
