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
import poll.models.Poll;
import poll.rep.PollRepository;

@RestController
@RequestMapping("/poll")
public class PollController {
	
	@Autowired
	private PollRepository pollRepository;
	
	// get all users
	@GetMapping("/getpolls")
	public List<Poll> getAllUsers(){
		return pollRepository.findAll();
	}
	
	@GetMapping("/getpolls/{pollid}")
	public ResponseEntity<Poll> getPollById(@PathVariable int pollid) {
		Poll poll = pollRepository.findById(pollid).orElse(null);		
		return ResponseEntity.ok(poll);
	}
	
	// create users rest API
	@PostMapping("/addpoll")
	public ResponseEntity<?> createUsers(@RequestBody Poll poll) {
		Poll save = this.pollRepository.save(poll);
		return ResponseEntity.ok(save);
	}
	
	// update user rest API
	
	@PutMapping("/updatepoll/{pollid}")
	public ResponseEntity<Poll> updateEmployee(@PathVariable int pollid, @RequestBody Poll pollDetails){
		Poll poll = pollRepository.findById(pollid)
					.orElse(null);
				
		poll.setPollname(pollDetails.getPollname());
		poll.setPollcreatedby(pollDetails.getPollcreatedby());
		poll.setQuestion(pollDetails.getQuestion());
		poll.setCategory(pollDetails.getCategory());
		poll.setOption1(pollDetails.getOption1());
		poll.setOption2(pollDetails.getOption2());
		poll.setCategory(pollDetails.getCategory());
		Poll updatedPoll = pollRepository.save(poll);
		return ResponseEntity.ok(updatedPoll);
	}
			
	// delete user rest API
	@DeleteMapping("/deletepoll/{pollid}")
	public ResponseEntity<Map<String, Boolean>> deletePolls(@PathVariable int pollid){
		Poll poll = pollRepository.findById(pollid)
					.orElse(null);
				
		pollRepository.delete(poll);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted poll", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}