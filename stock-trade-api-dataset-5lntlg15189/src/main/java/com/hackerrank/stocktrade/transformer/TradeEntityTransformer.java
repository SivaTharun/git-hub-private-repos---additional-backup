package com.hackerrank.stocktrade.transformer;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Function;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.entities.TradeEntity;
import com.hackerrank.stocktrade.repository.entities.UserEntity;

public class TradeEntityTransformer implements Function<Trade, TradeEntity> {
  @Override
  public TradeEntity apply(Trade trade) {
    UserEntity userEntity = new UserEntity();
    TradeEntity tradeEntity = new TradeEntity();
    tradeEntity.setId(trade.getId());
    tradeEntity.setPrice(trade.getPrice());
    tradeEntity.setShares(trade.getShares());
    tradeEntity.setSymbol(trade.getSymbol());
    tradeEntity.setType(trade.getType());
    tradeEntity.setTimestamp(Optional.ofNullable(trade.getTimestamp())
        .orElse(new Timestamp(System.currentTimeMillis()))
        .toInstant()
        .atZone(ZoneId.of("America/New_York"))
        .toLocalDate());
    userEntity.setUserId(trade.getUser().getId());
    userEntity.setUserName(trade.getUser().getName());
    tradeEntity.setUser(userEntity);
    return tradeEntity;
  }
}
