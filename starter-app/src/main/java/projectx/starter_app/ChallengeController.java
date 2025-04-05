package projectx.starter_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = {"http://localhost:5173", "https://challenge-appv4.netlify.app/"})
public class ChallengeController {
private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }
    @GetMapping //http://localhost:8080/challenges
    private ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
       Boolean isChallengeAdded = challengeService.addChallenge(challenge);
       if(isChallengeAdded){
           return new ResponseEntity<>("Challenge Added Successfully",HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>("Challenge Not Added",HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatingChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatingChallenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge Not Updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge Deleted Successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge Not Deleted",HttpStatus.NOT_FOUND);
        }
    }
}
