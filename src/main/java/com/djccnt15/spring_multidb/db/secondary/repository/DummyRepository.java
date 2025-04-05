package com.djccnt15.spring_multidb.db.secondary.repository;

import com.djccnt15.spring_multidb.db.secondary.entity.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<DummyEntity, Long> {
}
