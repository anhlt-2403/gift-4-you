package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.ProviderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProviderService {
    Page<ProviderResponse> getProviders(Pageable pageable);
    ProviderResponse getProviderById(UUID id) throws ArchitectureException;
    ProviderResponse createProvider(ProviderRequest providerRequest) throws ArchitectureException;
    ProviderResponse updateProvider(UUID id, ProviderRequest providerRequest)throws ArchitectureException;
}
