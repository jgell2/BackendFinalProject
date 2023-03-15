package com.promineotech.bands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.DeleteShowDao;
import com.promineotech.bands.entity.Shows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicDeleteShowService implements DeleteShowService {
  
  @Autowired
  DeleteShowDao deleteShowDao;

  @Override
  public void deleteShow(Long showPK) {
    log.debug("Show = {} has passed into service for deletion", showPK);
    deleteShowDao.deleteShow(showPK);
  }

}
