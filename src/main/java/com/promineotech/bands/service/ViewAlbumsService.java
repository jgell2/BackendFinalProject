package com.promineotech.bands.service;

import java.util.List;
import com.promineotech.bands.entity.Album;

//Get service interface to house all methods
public interface ViewAlbumsService {

  //method to view all albums, ran in implementing class
  List<Album> fetchAlbums();

}
