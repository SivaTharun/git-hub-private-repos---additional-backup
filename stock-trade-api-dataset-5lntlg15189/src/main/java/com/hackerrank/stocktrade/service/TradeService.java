package com.hackerrank.stocktrade.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService {

  ResponseEntity<String> addNewTrade(Trade trade) throws Exception;

  ResponseEntity<String> getTrade(Long tradeId) throws Exception;

  ResponseEntity<String> getAllTrades() throws Exception;

  ResponseEntity<String> getTradesByUser(Long userId) throws Exception;

  ResponseEntity<String> getTradesByStockSymbolByTypeBetweenStartDateAndEndDate(String stockSymbol, String tradeType, LocalDate startDate, LocalDate endDate)
      throws Exception;

  ResponseEntity<String> getStockSymbolByHighestAndLowestPrice(String stockSymbol, LocalDate startDate, LocalDate endDate)
      throws Exception;

}
