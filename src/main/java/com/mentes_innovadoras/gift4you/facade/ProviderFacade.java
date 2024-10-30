package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.CreateProviderRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.UpdateProviderRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import com.mentes_innovadoras.gift4you.services.interfaces.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderFacade {
    private final ProviderService providerService;

    public Object getProviders(Pageable pageable) {
        return providerService.getProviders(pageable);
    }

    public Object getProviderById(UUID id) throws ArchitectureException {
        return providerService.getProviderById(id);
    }

    public Object createProvider(CreateProviderRequest  createProviderRequest) throws ArchitectureException {
        return providerService.createProvider(createProviderRequest);
    }

    public Object updateProvider(UUID id, UpdateProviderRequest updateProviderRequest) throws ArchitectureException {
        return providerService.updateProvider(id, updateProviderRequest);
    }

}
