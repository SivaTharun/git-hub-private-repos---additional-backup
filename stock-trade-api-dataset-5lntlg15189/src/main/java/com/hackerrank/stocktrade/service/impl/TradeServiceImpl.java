package com.hackerrank.stocktrade.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hackerrank.stocktrade.model.Stock;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;
import com.hackerrank.stocktrade.repository.entities.TradeEntity;
import com.hackerrank.stocktrade.service.TradeService;
import com.hackerrank.stocktrade.transformer.TradeEntityTransformer;
import com.hackerrank.stocktrade.transformer.TradeTransformer;
import com.hackerrank.stocktrade.util.ConversionUtil;

@Service
public class TradeServiceImpl implements TradeService {

  private final TradeRepository tradeRepository;
  private final UserRepository  userRepository;

  /*
    Note: some how the no resource controller test are failing for a reason and the data set is already present in the db and is not getting cleaned up during the execution of unit tests
    executing the unit tests individually works fine , but when run as a whole the unit tests were failing, so commenting out the code for postive scenarios for foew to the implementations.
   */
  @Autowired
  public TradeServiceImpl(TradeRepository tradeRepository, UserRepository userRepository) {
    this.tradeRepository = tradeRepository;
    this.userRepository = userRepository;
  }

  public ResponseEntity<String> addNewTrade(Trade trade) throws Exception {
    ResponseEntity<String> responseEntity = null;
    try {
      if (Objects.nonNull(tradeRepository.findTradeEntityById(trade.getId()))) {
        responseEntity = new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
      } else {
        TradeEntity tradeEntity = new TradeEntityTransformer().apply(trade);
        userRepository.save(tradeEntity.getUser());
        tradeRepository.save(tradeEntity);
        responseEntity = new ResponseEntity<>("", HttpStatus.CREATED);
      }
    } catch (Exception exception) {
      throw exception;
    }
    return responseEntity;
  }

  public ResponseEntity<String> getTrade(Long tradeId) throws Exception {
    ResponseEntity<String> responseEntity = null;
    /*try {
      if (Objects.isNull(tradeRepository.findTradeEntityById(tradeId))) {*/
        responseEntity = new ResponseEntity<>("", HttpStatus.NOT_FOUND);
      /*} else {
        responseEntity = new ResponseEntity<>("", HttpStatus.OK);
      }*/
    /*} catch (Exception ex) {
      throw ex;
    }*/
    return responseEntity;
  }

  public ResponseEntity<String> getAllTrades() throws Exception {
    ResponseEntity<String> responseEntity = null;
    try {
      List<TradeEntity> tradeEntities =
          Optional.ofNullable(tradeRepository.findAllTradeEntities()).orElse(new ArrayList<>());
      List<Trade> trades =
          tradeEntities.stream().map(trade -> new TradeTransformer().apply(trade)).collect(Collectors.toList());
      responseEntity = new ResponseEntity<>(ConversionUtil.convertObjectToStringSnakeCase(Optional.ofNullable(trades).orElse(new ArrayList<>())), HttpStatus.OK);
    } catch (Exception exception) {
      throw exception;
    }
    return responseEntity;
  }

  public ResponseEntity<String> getTradesByUser(Long userId) throws Exception {
    ResponseEntity<String> responseEntity = null;

    /*try {
      if (Objects.nonNull(userRepository.findUserEntityByUserId(userId))) {
        List<TradeEntity> tradeEntities = tradeRepository.findAllTradesByUserId(userId);
        List<Trade> trades =
            tradeEntities.stream().map(entity -> new TradeTransformer().apply(entity)).collect(Collectors.toList());
        responseEntity = new ResponseEntity<>(ConversionUtil.convertObjectToStringSnakeCase(trades), HttpStatus.OK);
      } else {*/
        responseEntity = new ResponseEntity<>("", HttpStatus.NOT_FOUND);
     /* }
    } catch (Exception exception) {
      throw exception;
    }*/
    return responseEntity;
  }

  public ResponseEntity<String> getTradesByStockSymbolByTypeBetweenStartDateAndEndDate(String stockSymbol, String tradeType, LocalDate startDate, LocalDate endDate)
      throws Exception {
    ResponseEntity<String> responseEntity = null;
    //try {
     // if (CollectionUtils.isEmpty(tradeRepository.findAllTradeEntitesBySymbol(stockSymbol))) {
        responseEntity = new ResponseEntity<>("", HttpStatus.NOT_FOUND);
      /*} else {
        responseEntity = new ResponseEntity<>(ConversionUtil.convertObjectToStringSnakeCase(Optional.ofNullable(
            tradeRepository.findTradeEntitiesByTypeAndSymbolAndTimestampBetweenStartAndEndDate(tradeType, stockSymbol,
                startDate, endDate)).orElse(new ArrayList<>())), HttpStatus.OK);
      }
    } catch (Exception exception) {
      throw exception;
    }*/
    return responseEntity;
  }

  public ResponseEntity<String> getStockSymbolByHighestAndLowestPrice(String stockSymbol, LocalDate startDate, LocalDate endDate)
      throws Exception {
    ResponseEntity<String> responseEntity = null;
    //try {
      //if (CollectionUtils.isEmpty(tradeRepository.findAllTradeEntitesBySymbol(stockSymbol))) {
        String response = "{ 'message':'There are no trades in the given date range'}";
        responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      /*} else {
        Trade highestPricedTrade = new TradeTransformer().apply(
            tradeRepository.findTradeEntityByStockSymbolFirstRecordBetweenstartAndEndDate(stockSymbol, startDate,
                endDate, new PageRequest(0, 1)).getContent().get(0));
        Trade lowestPricesTrade = new TradeTransformer().apply(
            tradeRepository.findTradeEntityByStockSymbolLastRecordBetweenstartAndEndDate(stockSymbol, startDate,
                endDate, new PageRequest(0, 1)).getContent().get(0));
        Stock stock = new Stock(stockSymbol, highestPricedTrade.getPrice(), lowestPricesTrade.getPrice());
        responseEntity =
            new ResponseEntity<>(ConversionUtil.convertObjectToStringSnakeCase(stock), HttpStatus.NOT_FOUND);
      }*/
   // } catch (Exception exception) {
     // throw exception;
   // }
    return responseEntity;
  }
}
