package com.motorbikes.service;

import com.motorbikes.model.Score;
import com.motorbikes.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author 71GM30
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
 
    public List<Score> getAll(){
       return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int scoreId) {
        return scoreRepository.getScore(scoreId);
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
    
    //idscore,messagetext,stars
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> evento=scoreRepository.getScore(score.getIdScore());
            if(!evento.isEmpty()){
                if(score.getMessageText()!=null){
                    //evento.get().setStartDate(reservation.getStartDate());
                    evento.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    evento.get().setStars(score.getStars());
                }
                scoreRepository.save(evento.get());
                return evento.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean delete(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

