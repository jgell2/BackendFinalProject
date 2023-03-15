package com.promineotech.bands.dao;

import java.util.List;
import com.promineotech.bands.entity.Band;

public interface ViewBandsDao {

  List<Band> fetchBands();

}
