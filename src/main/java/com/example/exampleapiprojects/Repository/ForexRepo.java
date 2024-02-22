package com.example.exampleapiprojects.Repository;

import com.example.exampleapiprojects.util.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ForexRepo extends MongoRepository<Forex, String> {
    public Optional<Forex> findByDate(String date);


}
