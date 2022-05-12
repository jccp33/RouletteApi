package com.ibm.academi.RouletteApi.repositories;

import com.ibm.academi.RouletteApi.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
