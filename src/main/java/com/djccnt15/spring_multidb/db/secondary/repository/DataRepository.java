package com.djccnt15.spring_multidb.db.secondary.repository;

import com.djccnt15.spring_multidb.db.secondary.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
