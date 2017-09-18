package com.lzw.compensation.domain.repository;

import com.lzw.compensation.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
