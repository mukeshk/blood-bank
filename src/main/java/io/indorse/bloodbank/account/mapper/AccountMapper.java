package io.indorse.bloodbank.account.mapper;

import io.indorse.bloodbank.common.mapper.AddressMapper;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.dto.BloodBankAccountDTO;

public class AccountMapper {

    public static BloodBankAccount mapNewInstance(BloodBankAccountDTO accountDTO){
        BloodBankAccount account = new BloodBankAccount();
        account.setBirthDate(accountDTO.getBirthDate());
        account.setBloodGroup(accountDTO.getBloodGroup());
        account.setEmail(accountDTO.getEmail());
        account.setFirstName(accountDTO.getFirstName());
        account.setMiddleName(accountDTO.getMiddleName());
        account.setLastName(accountDTO.getLastName());
        account.setGender(accountDTO.getGender());
        account.setAddress(AddressMapper.map(accountDTO.getAddress()));
        return account;
    }



    public static BloodBankAccountDTO map(BloodBankAccount account){
        BloodBankAccountDTO accountDTO = new BloodBankAccountDTO();
        accountDTO.setBirthDate(account.getBirthDate());
        accountDTO.setBloodGroup(account.getBloodGroup());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setFirstName(account.getFirstName());
        accountDTO.setMiddleName(account.getMiddleName());
        accountDTO.setLastName(account.getLastName());
        accountDTO.setGender(account.getGender());
        accountDTO.setAddress(AddressMapper.map(account.getAddress()));
        accountDTO.setUuid(account.getUuid());
        return accountDTO;
    }
}
