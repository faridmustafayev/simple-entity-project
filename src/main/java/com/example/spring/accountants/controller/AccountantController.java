package com.example.spring.accountants.controller;

import com.example.spring.accountants.model.request.CreateOrUpdateAccountantRequest;
import com.example.spring.accountants.model.response.AccountantResponse;
import com.example.spring.accountants.service.abstraction.AccountantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/accountants")
@RequiredArgsConstructor
public class AccountantController {
    private final AccountantService accountantService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createAccountant(@RequestBody CreateOrUpdateAccountantRequest request) {
        accountantService.createAccountant(request);
    }

    @GetMapping("/{id}")
    public AccountantResponse getAccountant(@PathVariable Long id){
        return accountantService.getAccountant(id);
    }

    @GetMapping
    public List<AccountantResponse> getAccountants(){
        return accountantService.getAccountants();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteAccountant(@PathVariable Long id){
        accountantService.deleteAccountant(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateAccountant(@PathVariable Long id,
                                 CreateOrUpdateAccountantRequest request){
        accountantService.updateAccountant(id, request);
    }


}
