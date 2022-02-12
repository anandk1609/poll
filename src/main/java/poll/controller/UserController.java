package poll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poll.models.Users;
import poll.rep.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	// get all users
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}	
	
	//get all users in login check
	@GetMapping("/login-users")
	public List<Users> getAllUsers1(){
		return userRepository.findAll();
	}	
	
	// create users rest API
		@PostMapping("/users")
		public ResponseEntity<?> createUsers(@RequestBody Users user) {
			Users save = this.userRepository.save(user);
			return ResponseEntity.ok(save);
		}
		
		@PostMapping("/registerusers")
		public ResponseEntity<?> createUsers1(@RequestBody Users user1) {
			Users save = this.userRepository.save(user1);
			return ResponseEntity.ok(save);
		}
	
		
		// get user by id rest API
		@GetMapping("/users/{id}")
		public ResponseEntity<Users> getEmployeeById(@PathVariable int id) {
			Users user = userRepository.findById(id)
					.orElse(null);
			return ResponseEntity.ok(user);
		}
		
		// update user rest API
		
		@PutMapping("/users/{id}")
		public ResponseEntity<Users> updateEmployee(@PathVariable int id, @RequestBody Users userDetails){
			Users user = userRepository.findById(id)
					.orElse(null);
			
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setEmail(userDetails.getEmail());
			user.setMobile(userDetails.getMobile());
			user.setUserName(userDetails.getUserName());
			user.setPassword(userDetails.getPassword());			
			Users updatedUsers = userRepository.save(user);
			return ResponseEntity.ok(updatedUsers);
		}
		
		// delete user rest API
		@DeleteMapping("/users/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable int id){
			Users user = userRepository.findById(id)
					.orElse(null);
			
			userRepository.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted user", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}


