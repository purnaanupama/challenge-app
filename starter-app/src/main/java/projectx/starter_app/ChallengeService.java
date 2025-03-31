package projectx.starter_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;
    //private List<Challenge> challenges = new ArrayList<>(); //challenges that is capable of storing a list of Challenge objects
    public List<Challenge> getAllChallenges(){ return challengeRepository.findAll();}


    public Boolean addChallenge(Challenge challenge){
        if(challenge != null){
            challengeRepository.save(challenge);
            challenge.setId(nextId++);
            return true;
        } else {
            return false;
        }
    }

    public Challenge getChallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatingChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updatingChallenge.getMonth());
            challengeToUpdate.setDescription(updatingChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
     return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
    return false;
    }
}
