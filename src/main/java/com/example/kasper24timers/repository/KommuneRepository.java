package com.example.kasper24timers.repository;

import com.example.kasper24timers.model.Kommune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface KommuneRepository extends CrudRepository<Kommune, Long> {
}
