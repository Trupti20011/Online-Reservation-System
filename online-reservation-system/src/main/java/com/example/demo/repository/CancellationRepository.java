package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Cancellation;

public interface CancellationRepository extends JpaRepository<Cancellation, Long> {
}
