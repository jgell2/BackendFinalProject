package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewAlbumsDao;
import com.promineotech.bands.entity.Album;
import lombok.extern.slf4j.Slf4j;

//implementing class of get service interface
@Service
@Slf4j
public class BasicViewAlbumsService implements ViewAlbumsService {
  
  //instance of the ViewAlbumsDao interface is created
  @Autowired
  private ViewAlbumsDao viewAlbumsDao;

  /*logs a line in the console to ensure data has passed through the service layer & 
   *runs the fetch albums method in the DAO interface 
   **/
  @Override
  public List<Album> fetchAlbums() {
    log.info("fetchAlbums running in Service");
    return viewAlbumsDao.fetchAlbums();
  }

}
