package com.hackerrank.stocktrade.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class ConversionUtil {

  public static String convertObjectToStringSnakeCase(Object object) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    return mapper.writeValueAsString(object);
  }

}
