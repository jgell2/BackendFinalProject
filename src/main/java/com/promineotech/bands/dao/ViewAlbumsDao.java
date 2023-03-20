package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Album;

//DAO layer interface for the get methods on the Album entity
public interface ViewAlbumsDao {

  List<Album> fetchAlbums();

}
