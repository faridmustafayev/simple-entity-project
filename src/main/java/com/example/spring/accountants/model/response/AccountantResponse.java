package com.example.spring.accountants.model.response;

import com.example.spring.accountants.model.enums.AccountantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountantResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal salary;
    private AccountantStatus status;
}
