package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "select case when max(score) is null then '0' else max(score) end from submission as sub\n" +
            "join challenge as cha on sub.challenge_id = cha.id\n" +
            "where cha.id = :challengeId ",nativeQuery = true)
    BigDecimal findByScoreMax(@Param("challengeId") Long challengeId);

    @Query(value = "select * from submission as sub\n" +
            "join challenge as cha on cha.id = sub.challenge_id\n" +
            "join acceleration as acc on acc.challenge_id = cha.id\n" +
            "where acc.id = :accelerationId and cha.id = :challengeId", nativeQuery = true)
    List<Submission> findBySubmission(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
