package com.promineotech.bands.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.bands.dao.ViewShowsDao;
import com.promineotech.bands.entity.Shows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicViewShowsService implements ViewShowsService {
  
  @Autowired
  private ViewShowsDao viewShowsDao;

  @Transactional(readOnly = true)
  @Override
  public List<Shows> fetchShows() {
    log.info("fetchShows running...-service");
    
    List<Shows> shows = viewShowsDao.fetchShows();
    
    if(shows.isEmpty()) {
      String msg = String.format("No shows were found");
      
      throw new NoSuchElementException(msg);
    }
    
    return shows;
  }

}
