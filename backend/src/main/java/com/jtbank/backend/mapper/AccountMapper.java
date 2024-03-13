package com.jtbank.backend.mapper;

import com.jtbank.backend.dto.AccountRequestDTO;
import com.jtbank.backend.dto.AccountResponseDTO;
import com.jtbank.backend.model.Account;
import com.jtbank.backend.model.Credential;
import org.springframework.beans.BeanUtils;

public class AccountMapper {
    private AccountMapper(){}

    public static Account modelMapper(AccountRequestDTO dto){
        var account = new Account();
//        BeanUtils.copyProperties(dto,account); //if variable name is same then auto set the value
        account.setAccountHolderName(dto.accountHolderName());
        account.setAboutCustomer(dto.aboutCustomer());
        account.setContactNumber(dto.contactNumber());
        account.setAccountType(dto.accountType());

        var credential = new Credential();
//        BeanUtils.copyProperties(dto,credential);
        credential.setAccountEmail(dto.accountEmail());
        credential.setAccountPassword(dto.accountPassword());

        account.setCredential(credential);
        return account;
    }
    public static AccountResponseDTO dtoMapper(Account account){
        var accountNumber = account.getAccountNumber();
        var accountHolderName = account.getAccountHolderName();
        var aboutCustomer = account.getAboutCustomer();
        var contactNumber = account.getContactNumber();
        var accountType = account.getAccountType();

//        var accountBalance = account.getAccountBalance();
        var accountBalance = 0;

        var credential = account.getCredential();
        var customerPassword = credential.getAccountPassword();
        var customerEmail = credential.getAccountEmail();

        return new AccountResponseDTO(
                accountHolderName,
                aboutCustomer,
                contactNumber,
                accountType,
                customerEmail,
                customerPassword,
                accountNumber,
                accountBalance
        );
    }
}
