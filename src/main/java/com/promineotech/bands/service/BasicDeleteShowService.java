package com.promineotech.bands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.DeleteShowDao;
import com.promineotech.bands.entity.Shows;
import lombok.extern.slf4j.Slf4j;

//implementing class of the delete show service interface
@Service
@Slf4j
public class BasicDeleteShowService implements DeleteShowService {
  
  //implements an instance of the Delete Show DAO interface
  @Autowired
  DeleteShowDao deleteShowDao;

  /**
   * logs a line in the console letting the user know the request has passed into the service layer,
   * runs and returns the delete method on the Dao interface
   * */
  @Override
  public void deleteShow(Long showPK) {
    log.debug("Show = {} has passed into service for deletion", showPK);
    deleteShowDao.deleteShow(showPK);
  }

}
