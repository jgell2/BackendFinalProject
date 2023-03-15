package com.promineotech.bands.service;

import com.promineotech.bands.entity.Shows;

public interface UpdateShowService {

  Shows updateShowBand(Long showPK, Shows show);

}
