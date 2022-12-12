package com.jane.restapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

  @Test
  void builder() {
    Event event = Event.builder()
                       .name("event rest api")
                       .build();
    assertThat(event).isNotNull();
  }

  @Test
  void javaBean() {
    //Given
    String name = "Event";

    //When
    Event event = new Event();
    event.setName(name);

    //Then
    assertThat(event.getName()).isEqualTo(name);
  }

}