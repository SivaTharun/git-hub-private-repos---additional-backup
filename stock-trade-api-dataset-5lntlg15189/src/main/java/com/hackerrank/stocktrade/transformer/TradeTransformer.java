package com.hackerrank.stocktrade.transformer;

import java.sql.Timestamp;
import java.util.function.Function;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repository.entities.TradeEntity;

public class TradeTransformer implements Function<TradeEntity, Trade> {

  @Override
  public Trade apply(TradeEntity tradeEntity) {
    User user = new User(tradeEntity.getUser().getUserId(), tradeEntity.getUser().getUserName());
    return new Trade(tradeEntity.getId(), tradeEntity.getType(), user, tradeEntity.getSymbol(), tradeEntity.getShares(),
        tradeEntity.getPrice(), Timestamp.valueOf(tradeEntity.getTimestamp().atStartOfDay()));
  }
}
