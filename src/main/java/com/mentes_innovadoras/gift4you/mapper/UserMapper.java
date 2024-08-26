package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.User;
import com.mentes_innovadoras.gift4you.payload.reponse.UserResponse;
import com.mentes_innovadoras.gift4you.payload.request.UserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {
     private final ModelMapper mapper;

     public UserMapper(ModelMapper mapper) {
          this.mapper = mapper;
     }

     public User toUserEntity(UserRequest userRequest) {
          return mapper.map(userRequest, User.class);
     }

     public UserResponse toUserResponse(User user) {
          return mapper.map(user, UserResponse.class);
     }
}
