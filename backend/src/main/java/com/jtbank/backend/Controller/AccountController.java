package com.jtbank.backend.Controller;

import com.jtbank.backend.dto.AccountRequestDTO;
import com.jtbank.backend.dto.AccountResponseDTO;
import com.jtbank.backend.mapper.AccountMapper;
import com.jtbank.backend.model.Account;
import com.jtbank.backend.model.Credential;
import com.jtbank.backend.service.IAccountService;
import com.jtbank.backend.utility.GenerateAccountNumber;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService accountService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO createAccount(@Valid @RequestBody AccountRequestDTO  accountRequestDTO){
        var account = AccountMapper.modelMapper(accountRequestDTO);
        var result = accountService.creatAccount(account);
        return AccountMapper.dtoMapper(result);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountResponseDTO accountByEmailAndPassword(@RequestBody Credential credential){
        var result = accountService.getAccountByEmailAndPassword(credential.getAccountEmail(),credential.getAccountPassword());
        return AccountMapper.dtoMapper(result);
    }

    @PutMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountResponseDTO updateAccount(@PathVariable long accountNumber,@RequestBody AccountRequestDTO dto){
        var account = AccountMapper.modelMapper(dto);
        var result = accountService.updateAccount(accountNumber,account);
        return AccountMapper.dtoMapper(result);
    }

    @PatchMapping("/deposit/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deposit(@RequestHeader long accountNumber,@PathVariable double balance){
        accountService.depositBalance(accountNumber,balance);
    }

    @PatchMapping("/withdrawl/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void withDraw(@RequestHeader long accountNumber,@PathVariable double balance){
        accountService.withDrawlBalance(accountNumber,balance);
    }

    @PatchMapping("/number/{receiver}/balance/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void transfer(@RequestHeader long sender,@PathVariable long receiver,@PathVariable double balance){
        accountService.transfer(sender,receiver,balance);
    }

    @DeleteMapping("/number/{accountNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountResponseDTO deleteByAccountNumber(@PathVariable int accountNumber){
        var result = accountService.deleteAccount(accountNumber);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping("/{slNo}")
    public AccountResponseDTO accountBySlNo(@PathVariable int slNo){
        var result = accountService.getAccountBySlNo(slNo);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping("/number/{accountNumber}")
    public AccountResponseDTO accountByNumber(@PathVariable long accountNumber){
        var result = accountService.getAccount(accountNumber);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping("/email/{email}")
    public AccountResponseDTO accountByEmail(@PathVariable String email){
        var result = accountService.getAccountByEmail(email);
        return AccountMapper.dtoMapper(result);
    }

    @GetMapping
    public List<AccountResponseDTO> accounts(){
        var results = accountService.getAccount();
        return results.stream().map(AccountMapper::dtoMapper).toList();
    }
}
