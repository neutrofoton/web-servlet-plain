package com.neutrofoton.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neutrofoton.spring.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal,Long>{

}
