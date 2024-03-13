package com.jtbank.backend.dto;

import com.jtbank.backend.constant.AccountType;
import jakarta.validation.constraints.NotNull;

public record AccountRequestDTO(
        @NotNull(message = "Name of the customer should not be null")
        String accountHolderName,
        @NotNull(message = "AboutCustomer should not be null")
        String aboutCustomer,
        @NotNull(message = "ContactNumber should not be null")
        String contactNumber,
        @NotNull(message = "AccountType should not be null")
        AccountType accountType,
        @NotNull(message = "AccountEmail should not be null")
        String accountEmail,
        @NotNull(message = "AccountPassword should not be null")
        String accountPassword
) {
}
