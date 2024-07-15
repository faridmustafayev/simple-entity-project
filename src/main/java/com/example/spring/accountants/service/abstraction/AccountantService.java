package com.example.spring.accountants.service.abstraction;

import com.example.spring.accountants.model.request.CreateOrUpdateAccountantRequest;
import com.example.spring.accountants.model.response.AccountantResponse;

import java.util.List;

public interface AccountantService {

    void createAccountant(CreateOrUpdateAccountantRequest request);

    AccountantResponse getAccountant(Long id);

    List<AccountantResponse> getAccountants();

    void deleteAccountant(Long id);

    void updateAccountant(Long id, CreateOrUpdateAccountantRequest request);
}
