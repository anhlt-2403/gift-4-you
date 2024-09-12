package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.provider.CreateProviderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    private final ModelMapper mapper;

    public ProviderMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Provider toProviderEntity(CreateProviderRequest providerRequest) {
        return mapper.map(providerRequest, Provider.class);
    }

    public ProviderResponse toProviderResponse(Provider provider) {
        return mapper.map(provider, ProviderResponse.class);
    }
}
