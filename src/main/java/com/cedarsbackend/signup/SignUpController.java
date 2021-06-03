package com.cedarsbackend.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cedarsbackend.video.Video;
import com.cedarsbackend.video.VideoRepository;

import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private SignUpRepository dao; 
	
	@GetMapping()
	public List<SignUp> getSignUp() {
		List<SignUp> foundSignUp = dao.findAll(); 
		return foundSignUp; 
	}
	
	@PostMapping()
	public ResponseEntity<SignUp> postSignUp(@RequestBody SignUp signup) {
		SignUp createdSignUp = dao.save(signup); 
		
		return ResponseEntity.ok(createdSignUp); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SignUp> updateSignUp(@PathVariable(value="id") Long id , @RequestBody SignUp signup) {
		SignUp foundSignUp = dao.findById(id).orElse(null); 
		
		if(foundSignUp == null) {
			return ResponseEntity.notFound().header("Signup", "Nothing found with that ID").build(); 
		}
		else {
			foundSignUp = dao.save(signup); 
		}
		return ResponseEntity.ok(foundSignUp); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SignUp> deleteSignUp(@PathVariable(value="id") Long id) {
		SignUp foundSignUp = dao.findById(id).orElse(null); 
		
		if(foundSignUp ==  null) {
			return ResponseEntity.notFound().header("Signup", "Nothing found with that ID").build(); 
		} else {
			dao.delete(foundSignUp); 
		}
		
		return ResponseEntity.ok().build(); 
	}
}
