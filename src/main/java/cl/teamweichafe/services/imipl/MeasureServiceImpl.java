package cl.teamweichafe.services.imipl;

import cl.teamweichafe.domain.Measure;
import cl.teamweichafe.repositories.MeasureRepository;
import cl.teamweichafe.services.MeasureService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class MeasureServiceImpl implements MeasureService {

    private final MeasureRepository measureRepository;

    public MeasureServiceImpl(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @Override
    public MongoRepository<Measure, String> getRepository() {
        return this.measureRepository;
    }
}
