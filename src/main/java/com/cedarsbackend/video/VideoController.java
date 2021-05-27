package com.cedarsbackend.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class VideoController {
	
	@Autowired
	private VideoRepository dao; 
	
	@GetMapping("/video")
	public List<Video> getVideos() {
		List<Video> foundVideos = dao.findAll(); 
		return foundVideos; 
	}
	
	@PostMapping("/video")
	public ResponseEntity<Video> postVideo(@RequestBody Video video) {
		Video createdVideo = dao.save(video); 
		
		return ResponseEntity.ok(createdVideo); 
	}
	
//	@PutMapping("/video/{id}")
//	public 
	
	@DeleteMapping("/video/{id}")
	public ResponseEntity<Video> deleteVideo(@PathVariable(value="id") Long id) {
		Video foundVideo = dao.findById(id).orElse(null); 
		
		if(foundVideo ==  null) {
			return ResponseEntity.notFound().header("Video", "Nothing found with that ID").build(); 
		} else {
			dao.delete(foundVideo); 
		}
		
		return ResponseEntity.ok().build(); 
	}

}
