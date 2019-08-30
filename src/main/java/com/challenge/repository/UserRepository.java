package com.challenge.repository;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByCandidatesIdCompanyId(Long userId);

    @Query(value = "select * from acceleration as ac\n" +
            "join candidate as cd on cd.acceleration_id = ac.id\n" +
            "join users as us on us.id = cd.user_id\n" +
            "where ac.name =:nameAc" ,nativeQuery = true)
    List<User> findByNameAcceleration(@Param("nameAc") String name);

}
