package com.example.spring.accountants.service.concrete;

import com.example.spring.accountants.dao.entity.AccountantEntity;
import com.example.spring.accountants.dao.repository.AccountantRepository;
import com.example.spring.accountants.model.exception.ErrorMessage;
import com.example.spring.accountants.model.exception.NotFoundException;
import com.example.spring.accountants.model.request.CreateOrUpdateAccountantRequest;
import com.example.spring.accountants.model.response.AccountantResponse;
import com.example.spring.accountants.service.abstraction.AccountantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring.accountants.mapper.AccountantMapper.ACCOUNTANT_MAPPER;
import static com.example.spring.accountants.model.enums.AccountantStatus.DELETED;

@Service
@RequiredArgsConstructor
public class AccountantServiceHandler implements AccountantService {
    private final AccountantRepository accountantRepository;

    @Override
    public void createAccountant(CreateOrUpdateAccountantRequest request) {
        accountantRepository.save(ACCOUNTANT_MAPPER.buildAccountantEntity(request));
    }

    @Override
    public AccountantResponse getAccountant(Long id) {
        return ACCOUNTANT_MAPPER.mapEntityToResponse(fetchAccountantIfExist(id));
    }

    @Override
    public List<AccountantResponse> getAccountants() {
        return accountantRepository.findAll()
                .stream()
                .map(ACCOUNTANT_MAPPER::mapEntityToResponse)
                .toList();
    }

    @Override
    public void deleteAccountant(Long id) {
        var accountantEntity = fetchAccountantIfExist(id);
        accountantEntity.setStatus(DELETED);
        accountantRepository.save(accountantEntity);
    }

    @Override
    public void updateAccountant(Long id, CreateOrUpdateAccountantRequest request) {
        var accountantEntity = fetchAccountantIfExist(id);
        if (request.getFirstName() != null) {
            accountantEntity.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            accountantEntity.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            accountantEntity.setEmail(request.getEmail());
        }
        if (request.getSalary() != null) {
            accountantEntity.setSalary(request.getSalary());
        }

        accountantRepository.save(accountantEntity);
    }

    private AccountantEntity fetchAccountantIfExist(Long id) {
        return accountantRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.USER_NOT_FOUND.name()));
    }

//    @PostConstruct
//    public void check() {
//        var withStatus = accountantRepository.getWithEmail(DRAFT.name());
//        withStatus.forEach(
//                it-> System.out.println("order_status: " + it.getEmail())
//        );
//    }

}
