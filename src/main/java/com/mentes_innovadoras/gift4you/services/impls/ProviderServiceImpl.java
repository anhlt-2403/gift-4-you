package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.enums.ProviderStatus;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.ProviderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.provider.CreateProviderRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.UpdateProviderRequest;
import com.mentes_innovadoras.gift4you.repository.ProviderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;
    @Override
    public PagedModel<ProviderResponse> getProviders(Pageable pageable) {
        return new PagedModel<>(providerRepository.findAll(pageable).map(providerMapper::toProviderResponse));
    }

    @Override
    public ProviderResponse getProviderById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return providerRepository.findById(id).map(providerMapper::toProviderResponse).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.providerNotFound));
    }

    @Override
    public ProviderResponse createProvider(CreateProviderRequest createProviderRequest) throws ArchitectureException {
        Provider newProvider = providerMapper.toProviderEntity(createProviderRequest);
        newProvider.setId(UUID.randomUUID());
        newProvider.setCreateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newProvider.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newProvider.setStatus(ProviderStatus.active.name());
        return providerMapper.toProviderResponse(providerRepository.save(newProvider));
    }

    @Override
    public ProviderResponse updateProvider(UUID id, UpdateProviderRequest updateProviderRequest) throws ArchitectureException {
        Provider provider = providerRepository.findById(id).orElseThrow(() ->new NotFoundException(ResponseConstant.Message.providerNotFound));
        provider.setName(updateProviderRequest.getName() == null ? provider.getName() : updateProviderRequest.getName());
        provider.setContactInfo(updateProviderRequest.getContactInfo() == null ? provider.getContactInfo() : updateProviderRequest.getContactInfo());
        provider.setAddress(updateProviderRequest.getAddress() == null ? provider.getAddress() : updateProviderRequest.getAddress());
        provider.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        return providerMapper.toProviderResponse(providerRepository.save(provider));
    }
}
