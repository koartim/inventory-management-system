package com.wakeferndemo.repository;

import com.wakeferndemo.models.RestockingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestockingRepository extends JpaRepository<RestockingRequest, Long> {
}
