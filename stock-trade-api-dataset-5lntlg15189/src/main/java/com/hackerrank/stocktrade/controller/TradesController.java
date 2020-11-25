package com.hackerrank.stocktrade.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;

@RestController
public class TradesController {

  private final TradeService tradeService;

  @Autowired
  public TradesController(TradeService tradeService) {
    this.tradeService = tradeService;
  }

  @PostMapping(value = "/trades", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
  public ResponseEntity<String> addNewTrade(@RequestBody Trade trade) throws Exception {
    return tradeService.addNewTrade(trade);
  }

  @GetMapping(value = "/trades/{id}")
  public ResponseEntity<String> getTrade(@PathVariable("id") Long tradeId) throws Exception {
    return tradeService.getTrade(tradeId);
  }

  @GetMapping(value = "/trades")
  public ResponseEntity<String> getAllTrades() throws Exception {
    return tradeService.getAllTrades();
  }

  @GetMapping(value = "/trades/users/{userID}")
  public ResponseEntity<String> getTradesByUser(@PathVariable("userID") Long userId) throws Exception {
    return tradeService.getTradesByUser(userId);
  }

  @GetMapping(value = "/trades/stocks/{stockSymbol}")
  public ResponseEntity<String> getTradesByStockSymbol(@PathVariable("stockSymbol") String stockSymbol, @RequestParam(value = "type") String tradeType, @RequestParam(value = "start") String startDate, @RequestParam(value = "end") String endDate)
      throws Exception {
    return tradeService.getTradesByStockSymbolByTypeBetweenStartDateAndEndDate(stockSymbol, tradeType,
        LocalDate.parse(startDate), LocalDate.parse(endDate));
  }

}
