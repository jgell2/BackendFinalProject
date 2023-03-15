package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewVenuesDao;
import com.promineotech.bands.entity.Venue;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicViewVenuesService implements ViewVenuesService {
  
  @Autowired
  ViewVenuesDao viewVenuesDao;

  @Override
  public List<Venue> fetchVenues() {
    log.info("fetching all venues - service");
    return viewVenuesDao.fetchVenues();
  }

}
