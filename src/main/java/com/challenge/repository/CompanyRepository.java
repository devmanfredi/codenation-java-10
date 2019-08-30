package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByCandidatesIdUserId(Long userId);

    @Query(value = "select distinct co.* from company as co\n" +
            "join candidate as ca on ca.company_id = co.id\n" +
            "join acceleration as ac on ca.acceleration_id = ac.id\n" +
            "where ac.id = :accelerationId", nativeQuery = true)
    List<Company> findByCompanyWhereAccelerationId(@Param("accelerationId") Long accelerationId);
}
