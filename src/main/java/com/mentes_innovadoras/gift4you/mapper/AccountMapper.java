package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.account.CreateAccountRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class AccountMapper {
     private final ModelMapper mapper;

     public AccountMapper(ModelMapper mapper) {
          this.mapper = mapper;
     }

     public Account toAccountEntity(CreateAccountRequest accountRequest) {
          return mapper.map(accountRequest, Account.class);
     }

     public AccountResponse toAccountResponse(Account account) {
          AccountResponse response = mapper.map(account, AccountResponse.class);
          response.setRole(account.getRole().getName());
          return response;
     }
}
