package com.hackerrank.stocktrade.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {

  @DeleteMapping(value = "/erase")
  public void eraseAllTrades() throws Exception {
    try {
    } catch (Exception e) {
      throw e;
    }
  }

}
