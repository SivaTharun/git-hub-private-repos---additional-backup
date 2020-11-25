package com.hackerrank.stocktrade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.repository.entities.TradeEntity;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

  @Query("select u from TradeEntity u where u.id = :tradeId")
  TradeEntity findTradeEntityById(@Param("tradeId") Long tradeId);

  @Query("select u from TradeEntity u order by u.id")
  List<TradeEntity> findAllTradeEntities();

  @Query("select u from TradeEntity u where u.user.userId = :userId order by u.id")
  List<TradeEntity> findAllTradesByUserId(@Param("userId") Long userId);

  @Query("select u from TradeEntity u where u.symbol = :stockSymbol")
  List<TradeEntity> findAllTradeEntitesBySymbol(@Param("stockSymbol") String stockSymbol);

  @Query("select u from TradeEntity u where u.type = :type and u.symbol = :stockSymbol and u.timestamp between :startDate and :endDate order by u.id")
  List<TradeEntity> findTradeEntitiesByTypeAndSymbolAndTimestampBetweenStartAndEndDate(@Param("type") String type, @Param("stockSymbol") String stockSymbol, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

  @Query("select u from TradeEntity u where u.symbol = :stockSymbol and u.timestamp between :startDate and :endDate order by u.price")
  Page<TradeEntity> findTradeEntityByStockSymbolFirstRecordBetweenstartAndEndDate(@Param("stockSymbol") String stockSymbol, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

  @Query("select u from TradeEntity u where u.symbol = :stockSymbol and u.timestamp between :startDate and :endDate order by u.price desc")
  Page<TradeEntity> findTradeEntityByStockSymbolLastRecordBetweenstartAndEndDate(@Param("stockSymbol") String stockSymbol, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

}
