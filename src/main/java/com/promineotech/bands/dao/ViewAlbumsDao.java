package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Album;

public interface ViewAlbumsDao {

  List<Album> fetchAlbums();

}
