package com.promineotech.bands.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewBandsDao;
import com.promineotech.bands.entity.Band;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicViewBandsService implements ViewBandsService {
  
  @Autowired
  private ViewBandsDao viewBandsDao;

  @Override
  public List<Band> fetchBands() {
    log.info("fetchBands running... - service");
    
    List<Band> bands = viewBandsDao.fetchBands();
    
    if(bands.isEmpty()) {
      String msg = String.format("No bands were found");
      
      throw new NoSuchElementException(msg);
    }
    
    return bands;
  }

}
