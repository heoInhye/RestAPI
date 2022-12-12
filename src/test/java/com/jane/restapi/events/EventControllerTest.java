package com.jane.restapi.events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest //@Controller, @RestController가 설정된 클래스를 메모리에 생성
class EventControllerTest {

  @Autowired
  MockMvc mockMvc; //서블릿 컨테이너를 모킹

  @Test
  void createEvent() throws Exception {
    mockMvc.perform(
              post("/api/events/")
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaTypes.HAL_JSON)
            )
            .andExpect(status().isCreated());
  }


}