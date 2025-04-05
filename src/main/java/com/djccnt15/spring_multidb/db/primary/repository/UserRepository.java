package com.djccnt15.spring_multidb.db.primary.repository;

import com.djccnt15.spring_multidb.db.primary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
