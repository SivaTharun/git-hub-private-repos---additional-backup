package com.novopay.repository.entities;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  @Modifying
  @Query("UPDATE UserEntity u set u.userLoggedIn = :loginStatus WHERE u.userId= :userId")
  int updateLoginStatus(@Param("loginStatus") String loginStatus, @Param("userId") Long userId);

  @Modifying
  @Query("UPDATE UserEntity u set u.accountBalance = :updatedBalance WHERE u.userId= :userId")
  int updateBalanceAmount(@Param("userId") Long userId, @Param("updatedBalance") Double updatedBalance);
}
