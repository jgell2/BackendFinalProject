package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewCitiesDao;
import com.promineotech.bands.entity.City;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicViewCitiesService implements ViewCitiesService {
  
  @Autowired
  private ViewCitiesDao viewCitiesDao;

  @Override
  public List<City> fetchBands() {
    log.info("fetching all cities - service");
    return viewCitiesDao.fetchBands();
  }

}
