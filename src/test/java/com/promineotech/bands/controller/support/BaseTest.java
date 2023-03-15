package com.promineotech.bands.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
  @LocalServerPort
  private int serverPort;
  
  @Autowired
  @Getter
  protected TestRestTemplate restTemplate;
  
  protected String getBaseUriForShows() {
    return String.format("http://localhost:%d/shows", serverPort);
  }
  
}
