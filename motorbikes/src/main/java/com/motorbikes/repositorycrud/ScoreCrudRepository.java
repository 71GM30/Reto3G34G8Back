package com.motorbikes.repositorycrud;

import com.motorbikes.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {

}
