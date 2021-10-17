package com.chanseok.provider.service;

import com.chanseok.provider.dto.ProviderDto;

import java.util.List;

public interface ProviderService {
    List<ProviderDto> findProviders();
}
