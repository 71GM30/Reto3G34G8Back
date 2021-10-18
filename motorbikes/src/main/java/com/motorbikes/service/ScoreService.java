package com.motorbikes.service;

import com.motorbikes.model.Score;
import com.motorbikes.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Score
 * @author dario
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
 
    public List<Score> getAll(){
       return scoreRepository.getAll();
    }
    
    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreUno = scoreRepository.getScore(score.getIdScore());
            if (scoreUno.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }
}
