package com.example.hiring_Chalenge.repositories;


import com.example.hiring_Chalenge.entities.BillsDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsData extends JpaRepository<BillsDataEntity,Long> {
}

