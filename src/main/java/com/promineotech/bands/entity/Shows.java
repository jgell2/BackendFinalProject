package com.promineotech.bands.entity;

import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shows {
  private Long showPK;
  private Band band;
  private City city;
  private Venue venue;
  private List<Genre> genres;
  
  



  }

