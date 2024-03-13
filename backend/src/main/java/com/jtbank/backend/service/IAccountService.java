package com.jtbank.backend.service;

import com.jtbank.backend.model.Account;

import java.util.List;

public interface IAccountService {
    Account creatAccount(Account account);
    Account updateAccount(long accountNumber , Account account);
    Account deleteAccount(long accountNumber);
    Account getAccount(long accountNumber);
    Account getAccountBySlNo(int slNo);
    Account getAccountByEmail(String email);
    Account getAccountByEmailAndPassword(String email,String password);
    void depositBalance(long accountNumber,double balance);
    void withDrawlBalance(long accountNumber,double balance);
    void transfer(long sender,long receiver,double balance);
    List<Account> getAccount();

}
