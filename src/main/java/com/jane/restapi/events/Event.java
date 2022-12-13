package com.jane.restapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder //기본생성자X
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of="id")
@Entity
public class Event {

  @Id @GeneratedValue
  private Integer id;

  private String name;
  private String description;
  private LocalDateTime beginEnrollmentDateTime;
  private LocalDateTime closeEnrollmentDateTime;
  private LocalDateTime beginEventDateTime;
  private LocalDateTime endEventDateTime;
  private String location; // (optional)
  private int basePrice; // (optional)
  private int maxPrice; // (optional)
  private int limitOfEnrollment;

  private boolean offline;
  private boolean free;

  @Enumerated(EnumType.STRING) //ORDINAL보다 권장
  private EventStatus eventStatus;

}
