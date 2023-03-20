package com.promineotech.bands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.UpdateShowDao;
import com.promineotech.bands.entity.Shows;
import lombok.extern.slf4j.Slf4j;


//implementing class for update shows service interface
@Service
@Slf4j
public class BasicUpdateShowService implements UpdateShowService {

  //implements a new object of update show Dao
  @Autowired
  private UpdateShowDao updateShowDao;
  
  /**
   * logs a line in the console letting the user know the request has passed into the service layer,
   * runs and returns the update method on the Dao interface
   * */
  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    log.debug("Show={} with request = {} has been passed in to Service", showPK, show);
    return updateShowDao.updateShowBand(showPK, show);
  }

}
