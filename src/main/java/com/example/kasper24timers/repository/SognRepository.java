package com.example.kasper24timers.repository;

import com.example.kasper24timers.model.Sogn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface SognRepository extends CrudRepository<Sogn, Long> {
}
