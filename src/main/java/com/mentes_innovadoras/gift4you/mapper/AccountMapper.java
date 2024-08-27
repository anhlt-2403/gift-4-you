package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.payload.reponse.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.AccountRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class AccountMapper {
     private final ModelMapper mapper;

     public AccountMapper(ModelMapper mapper) {
          this.mapper = mapper;
     }

     public Account toAccountEntity(AccountRequest accountRequest) {
          return mapper.map(accountRequest, Account.class);
     }

     public AccountResponse toAccountResponse(Account account) {
          return mapper.map(account, AccountResponse.class);
     }
}
