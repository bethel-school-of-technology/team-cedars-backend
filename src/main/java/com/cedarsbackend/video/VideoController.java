package com.cedarsbackend.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {
	
	@Autowired
	private VideoRepository dao; 
	
	@GetMapping()
	public List<Video> getVideos() {
		List<Video> foundVideos = dao.findAll(); 
		return foundVideos; 
	}
	
	@PostMapping()
	public ResponseEntity<Video> postVideo(@RequestBody Video video) {
		Video createdVideo = dao.save(video); 
		
		return ResponseEntity.ok(createdVideo); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Video> updateVideo(@PathVariable(value="id") Long id , @RequestBody Video video) {
		Video foundVideo = dao.findById(id).orElse(null); 
		
		if(foundVideo == null) {
			return ResponseEntity.notFound().header("Video", "Nothing found with that ID").build(); 
		}
		else {
			foundVideo = dao.save(video); 
		}
		return ResponseEntity.ok(foundVideo); 
	}
	
	@DeleteMapping("/{id}")
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
