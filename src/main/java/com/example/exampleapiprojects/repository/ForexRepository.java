package com.example.exampleapiprojects.repository;

import com.example.exampleapiprojects.entity.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface  ForexRepository  extends MongoRepository<Forex,String> {
    @Query("{'date': {$gte: ?0, $lt:?1 }}")
    List<Forex> findForexBetweenDate(Date startDate, Date endDate);

}
