package cz.upce.nnpia_cv5.datafactory;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.TrainingUnit;
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TrainingUnitTestDataFactory {

    public static final String DEFAULT_COURT_NAME = "Test Kurt";

    @Autowired
    TrainingUnitRepository trainingUnitRepository;

    @Autowired
    CourtTestDataFactory courtTestDataFactory;

    public TrainingUnit saveTrainingUnit(TrainingUnit unit){
        if (unit.getFrom() == null) unit.setFrom(LocalDateTime.now().minusMinutes(30));
        if (unit.getTo() == null) unit.setTo(LocalDateTime.now());
        if (unit.getCourt() == null) unit.setCourt(courtTestDataFactory.saveCourt(new Court()));
        trainingUnitRepository.save(unit);
        return unit;
    }


}
