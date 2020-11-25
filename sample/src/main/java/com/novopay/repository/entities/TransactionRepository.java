package com.novopay.repository.entities;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {

  @Query("SELECT TransactionEntity T from JOIN T.transactionPartyEntity TE WHERE TE.creditorId = :userId")
  List<TransactionEntity> getTransactionsWithUserAsCreditor(@Param("userId") Long userId);

  @Query("SELECT TransactionEntity T from JOIN T.transactionPartyEntity TE WHERE TE.debitorId = :userId")
  List<TransactionEntity> getTransactionsWithUserAsDebitor(@Param("userId") Long userId);

}
