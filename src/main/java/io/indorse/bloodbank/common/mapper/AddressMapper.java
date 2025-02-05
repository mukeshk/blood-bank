package io.indorse.bloodbank.common.mapper;

import io.indorse.bloodbank.model.domain.Address;
import io.indorse.bloodbank.model.dto.AddressDTO;

public class AddressMapper {

    public static Address map(AddressDTO addressDTO){
        Address address = new Address();
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZipCode(addressDTO.getZipCode());
        return address;
    }

    public static AddressDTO map(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressLine1(address.getAddressLine1());
        addressDTO.setAddressLine2(address.getAddressLine2());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setZipCode(address.getZipCode());
        return addressDTO;
    }

    public static String mapToString(Address address){
        StringBuffer addressInfo = new StringBuffer();
        addressInfo.append(address.getAddressLine1());
        if(address.getAddressLine2()!=null){
            addressInfo.append(", " + address.getAddressLine2());
        }
        addressInfo.append(", "+ address.getCity());
        addressInfo.append(", "+ address.getState());
        addressInfo.append(", "+ address.getZipCode());
        return addressInfo.toString();
    }
}
