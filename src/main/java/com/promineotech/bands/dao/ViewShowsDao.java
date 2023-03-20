package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Shows;

//interface containing the view methods on the DAO layer for shows
public interface ViewShowsDao {

  List<Shows> fetchShows();

}
