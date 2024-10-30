package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.provider.CreateProviderRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.UpdateProviderRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface ProviderService {
    PagedModel<ProviderResponse> getProviders(Pageable pageable);
    ProviderResponse getProviderById(UUID id) throws ArchitectureException;
    ProviderResponse createProvider(CreateProviderRequest createProviderRequest) throws ArchitectureException;
    ProviderResponse updateProvider(UUID id, UpdateProviderRequest updateProviderRequest)throws ArchitectureException;
}
