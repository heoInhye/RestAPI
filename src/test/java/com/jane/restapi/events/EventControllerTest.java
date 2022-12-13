package com.jane.restapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest //@Controller, @RestController가 설정된 클래스를 메모리에 생성
class EventControllerTest {

  @Autowired
  MockMvc mockMvc; //서블릿 컨테이너를 모킹

  @Autowired
  ObjectMapper objectMapper; //json타입으로 손쉽게 변환가능

  @MockBean
  EventRepository eventRepository;

  @Test
  void createEvent() throws Exception {
    Event event = Event.builder()
                       .name("spring")
                       .build();

    event.setId(1000);
    Mockito.when(eventRepository.save(event)).thenReturn(event);

    mockMvc.perform(
              post("/api/events/")
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaTypes.HAL_JSON)
              .content(objectMapper.writeValueAsString(event))
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("id").exists())
            .andExpect(header().exists(HttpHeaders.LOCATION))
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
            ;
  }


}