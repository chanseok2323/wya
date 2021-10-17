package com.chanseok.provider.service;

import com.chanseok.provider.dto.ProviderDto;
import com.chanseok.provider.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    public List<ProviderDto> findProviders() {
        return providerRepository.findProviders();
    }
}
