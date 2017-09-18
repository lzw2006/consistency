package com.lzw.compensation.domain.repository;

import com.lzw.compensation.domain.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Platform findByBuzIdAndService(String buzId, String service);

}
