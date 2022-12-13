package com.jane.restapi.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(value="/api/events/", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

  private final EventRepository eventRepository;

  @Autowired
  public EventController(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }


  @PostMapping
  public ResponseEntity createEvent(@RequestBody Event event) {
    Event newEvent = this.eventRepository.save(event);

    //created()로 보낼 때 uri 필요
    URI createdUri = linkTo(EventController.class)
            .slash(newEvent.getId())
            .toUri();

    return ResponseEntity.created(createdUri).body(event);
  }

//  @PostMapping
//  public ResponseEntity createEvent(@RequestBody Event event) {
//    //created()로 보낼 때 uri 필요
//    URI createdUri = linkTo(EventController.class)
//                    .slash("{id}")
//                    .toUri();
//    event.setId(100);
//    return ResponseEntity.created(createdUri).body(event);
//  }


//  @PostMapping("/api/events/")
//  public ResponseEntity createEvent() {
//    //created()로 보낼 때 uri 필요
//    URI createdUri =
//    linkTo( methodOn(EventController.class).createEvent() )
//            .slash("{id}")
//            .toUri();
//
//    return ResponseEntity.created(createdUri).build();
//  }


}
