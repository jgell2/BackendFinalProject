package com.promineotech.bands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.UpdateShowDao;
import com.promineotech.bands.entity.Shows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicUpdateShowService implements UpdateShowService {

  @Autowired
  private UpdateShowDao updateShowDao;
  
  @Override
  public Shows updateShowBand(Long showPK, Shows show) {
    log.debug("Show={} with request = {} has been passed in to Service", showPK, show);
    return updateShowDao.updateShowBand(showPK, show);
  }

}
