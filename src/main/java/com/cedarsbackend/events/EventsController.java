package com.cedarsbackend.events;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class EventsController {
	
	@Autowired
	private EventsRepository eventsRepository;
	
	
	// get all events

	@GetMapping("/events")
	public List<Events> getAllEvents(){
		return eventsRepository.findAll();
		
	}
	
	// create events rest API
		@PostMapping("/events")
		public Events createEmployee(@RequestBody Events events) {
			return eventsRepository.save(events);
		}
		
		
		// get event by id rest API
		@GetMapping("/events/{id}")
		public ResponseEntity<Events> getEventsById(@PathVariable Long id) {
			Events events = eventsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundExepction("event does not exist :" + id));
			return ResponseEntity.ok(events);
		}
		

		// update event rest API
		
		@PutMapping("/events/{id}")
		public ResponseEntity<Events> updateEvents(@PathVariable Long id, @RequestBody Events eventsDetails){
			Events events = eventsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundExepction("Event not exist :" + id));
			
			events.setHostName(eventsDetails.getHostName());
			events.setEventTitle(eventsDetails.getEventTitle());
			events.setLocation(eventsDetails.getLocation());
			events.setTime(eventsDetails.getTime());
			events.setDate(eventsDetails.getDate());
			events.setImage(eventsDetails.getImage());
			events.setMonth(eventsDetails.getMonth());
			
			Events updatedEvents = eventsRepository.save(events);
			return ResponseEntity.ok(updatedEvents);
		}
		
		
		@DeleteMapping("/events/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEvents(@PathVariable Long id){
			Events events = eventsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundExepction("Employee not exist :" + id));
			
			eventsRepository.delete(events);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		


}
