package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Shows;

public interface ViewShowsDao {

  List<Shows> fetchShows();

}
