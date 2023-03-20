package com.promineotech.bands.service;

import java.util.List;
import com.promineotech.bands.entity.Band;

//interface for the get operations for Bands

public interface ViewBandsService {

  List<Band> fetchBands();

}
