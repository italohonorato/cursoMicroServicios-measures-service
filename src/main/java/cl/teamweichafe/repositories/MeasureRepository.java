package cl.teamweichafe.repositories;

import cl.teamweichafe.domain.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository  extends MongoRepository<Measure, String> {
}
