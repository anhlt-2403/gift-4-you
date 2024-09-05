package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.exception.account.ProviderNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.ProviderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.provider.ProviderRequest;
import com.mentes_innovadoras.gift4you.repository.ProviderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;
    @Override
    public Page<ProviderResponse> getProviders(Pageable pageable) {
        return providerRepository.findAll(pageable).map(providerMapper::toProviderResponse);
    }

    @Override
    public ProviderResponse getProviderById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        ProviderResponse providerResponse = providerRepository.findById(id).map(providerMapper::toProviderResponse).orElse(null);
        if (providerResponse == null) throw new ProviderNotFoundException();
        return providerResponse;
    }

    @Override
    public ProviderResponse createProvider(ProviderRequest providerRequest) throws ArchitectureException {
        Provider newProvider = providerMapper.toProviderEntity(providerRequest);
        newProvider.setId(UUID.randomUUID());
        newProvider.setCreateAt(new Date());
        newProvider.setUpdateAt(new Date());
        newProvider.setStatus(providerRequest.getStatus());
        newProvider.setContactInfo(providerRequest.getContactInfo());
        newProvider.setName(providerRequest.getName());
        newProvider.setAddress(providerRequest.getAddress());
        return providerMapper.toProviderResponse(providerRepository.save(newProvider));
    }

    @Override
    public ProviderResponse updateProvider(UUID id, ProviderRequest providerRequest) throws ArchitectureException {
        Provider provider = providerRepository.findById(id).orElse(null);
        if (provider == null) throw new ProviderNotFoundException();
        provider.setUpdateAt(new Date());
        provider.setStatus(providerRequest.getStatus());
        provider.setContactInfo(providerRequest.getContactInfo());
        provider.setName(providerRequest.getName());
        provider.setAddress(providerRequest.getAddress());
        return providerMapper.toProviderResponse(providerRepository.save(provider));
    }
}
