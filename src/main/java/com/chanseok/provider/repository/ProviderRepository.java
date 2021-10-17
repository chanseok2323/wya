package com.chanseok.provider.repository;

import com.chanseok.domain.Provider;
import com.chanseok.provider.dto.ProviderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @Query("select new com.chanseok.provider.dto.ProviderDto(m.nickname, p.location, p.verification) from Provider p join p.member m")
    List<ProviderDto> findProviders();
}
