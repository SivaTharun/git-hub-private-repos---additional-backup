package com.hackerrank.stocktrade.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.service.TradeService;

@RestController
public class StocksController {

  private final TradeService tradeService;

  @Autowired
  public StocksController(TradeService tradeService) {
    this.tradeService = tradeService;
  }

  @GetMapping(value = "/stocks/{stockSymbol}/price")
  public ResponseEntity<String> getHighestAndLowestPricesStock(@PathVariable("stockSymbol") String stockSymbol, @RequestParam(value = "start") String startDate, @RequestParam(value = "end") String endDate)
      throws Exception {
    return tradeService.getStockSymbolByHighestAndLowestPrice(stockSymbol, LocalDate.parse(startDate),
        LocalDate.parse(endDate));
  }
}
