package com.jtbank.backend.dto;

import com.jtbank.backend.constant.AccountType;

public record AccountResponseDTO(
        String accountHolderName,
        String aboutCustomer,
        String contactNumber,
        AccountType accountType,
        String accountEmail,
        String accountPassword,
        double accountBalance,
        long accountNumber
) {
}
