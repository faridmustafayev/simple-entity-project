package com.example.spring.accountants.mapper;

import com.example.spring.accountants.dao.entity.AccountantEntity;
import com.example.spring.accountants.model.request.CreateOrUpdateAccountantRequest;
import com.example.spring.accountants.model.response.AccountantResponse;

import static com.example.spring.accountants.model.enums.AccountantStatus.DRAFT;

public enum AccountantMapper {
    ACCOUNTANT_MAPPER;

    public AccountantEntity buildAccountantEntity(CreateOrUpdateAccountantRequest request) {
        return AccountantEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .salary(request.getSalary())
                .status(DRAFT)
                .build();
    }

    public AccountantResponse mapEntityToResponse(AccountantEntity accountantEntity) {
        return AccountantResponse.builder()
                .id(accountantEntity.getId())
                .firstName(accountantEntity.getFirstName())
                .lastName(accountantEntity.getLastName())
                .email(accountantEntity.getEmail())
                .salary(accountantEntity.getSalary())
                .status(accountantEntity.getStatus())
                .build();
    }
}
