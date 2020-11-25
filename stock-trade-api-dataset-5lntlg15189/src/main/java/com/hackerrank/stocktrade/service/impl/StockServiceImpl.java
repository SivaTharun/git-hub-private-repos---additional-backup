package com.hackerrank.stocktrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.service.StockService;

@Service
public class StockServiceImpl implements StockService {

  private final TradeRepository tradeRepository;

  @Autowired
  public StockServiceImpl(TradeRepository tradeRepository) {
    this.tradeRepository = tradeRepository;
  }

  public void deleteAllStocks() throws Exception {
    try {
      tradeRepository.deleteAll();
    } catch (Exception e) {
      throw e;
    }
  }
}
