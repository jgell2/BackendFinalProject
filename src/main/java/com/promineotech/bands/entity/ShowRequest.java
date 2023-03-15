package com.promineotech.bands.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class ShowRequest {
  @NotNull
  @Length(max = 60)
  private String band;
  
  @NotNull
  @Length(max = 50)
  private String city;
  
  @NotNull
  @Length(max = 50)
  private String state;
  
  @Length(max = 60)
  private String venue;
  
  private List<@NotNull @Length(max = 60) String> genres;

}
