package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.ProviderRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderFacade {
    private final ProviderService providerService;

    public Page<ProviderResponse> getProviders(Pageable pageable){
        return providerService.getProviders(pageable);
    }

    public Object getProviderById(UUID id) throws ArchitectureException {
        return providerService.getProviderById(id);
    }

    public Object CreateProvider(ProviderRequest providerRequest) throws ArchitectureException {
        return providerService.createProvider(providerRequest);
    }
}
