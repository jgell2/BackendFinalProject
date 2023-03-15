package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bands.entity.City;
import com.promineotech.bands.service.ViewCitiesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicViewCitiesController implements ViewCitiesController {
  
  @Autowired
  private ViewCitiesService viewCitiesService;

  @Override
  public List<City> fetchCities() {
    log.info("fetching all cities - controller");
    return viewCitiesService.fetchBands();
  }

}
