package com.promineotech.bands.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Class for the album entity, it uses a Band object for its band_fk column in the database
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {
  private Long albumPK;
  private Band band;
  private String albumName;

}
