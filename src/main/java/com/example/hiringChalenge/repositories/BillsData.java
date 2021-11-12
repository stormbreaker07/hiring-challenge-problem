package com.example.hiringChalenge.repositories;


import com.example.hiringChalenge.entities.BillsDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsData extends JpaRepository<BillsDataEntity,Long> {

    @Query
    public List<BillsDataEntity> findAllByDate(String date);
}

