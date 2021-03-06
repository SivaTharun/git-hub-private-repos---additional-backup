package com.hackerrank.stocktrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.repository.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query(value = "select u from UserEntity u where u.userId = :userId")
  UserEntity findUserEntityByUserId(@Param("userId") Long userId);

}
