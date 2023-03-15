package com.promineotech.bands.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bands.dao.ViewAlbumsDao;
import com.promineotech.bands.entity.Album;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicViewAlbumsService implements ViewAlbumsService {
  
  @Autowired
  private ViewAlbumsDao viewAlbumsDao;

  @Override
  public List<Album> fetchAlbums() {
    log.info("fetchAlbums running in Service");
    return viewAlbumsDao.fetchAlbums();
  }

}
