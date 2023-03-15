package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.Venue;
import com.promineotech.bands.service.ViewVenuesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicViewAllVenuesController implements ViewAllVenuesController {
  
  @Autowired
  private ViewVenuesService viewVenuesService;

  @Override
  public List<Venue> fetchVenue() {
    log.info("fetching all venues - controller");
    return viewVenuesService.fetchVenues();
  }

}
