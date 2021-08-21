package com.everis.msreports.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.msreports.entity.ReportGeneral;

public interface ReportsRepository extends ReactiveMongoRepository<ReportGeneral, String>{

}
