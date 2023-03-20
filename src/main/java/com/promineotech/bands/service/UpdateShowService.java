package com.promineotech.bands.service;

import com.promineotech.bands.entity.Shows;

//interface for the update operations for shows

public interface UpdateShowService {

  Shows updateShowBand(Long showPK, Shows show);

}
