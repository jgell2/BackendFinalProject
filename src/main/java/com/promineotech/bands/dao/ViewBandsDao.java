package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Band;

//interface containing the view methods on the DAO layer for bands
public interface ViewBandsDao {

  List<Band> fetchBands();

}
