package cz.upce.nnpia_cv5.datafactory;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.CourtTypeEnum;
import cz.upce.nnpia_cv5.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourtTestDataFactory {

    public static final String DEFAULT_COURT_NAME = "Test Kurt";

    @Autowired
    CourtRepository courtRepository;

    public Court saveCourt(Court court){
        if (court.getActive() == null) court.setActive(true);
        if (court.getName() == null) court.setName(DEFAULT_COURT_NAME);
        if (court.getType() == null) court.setType(CourtTypeEnum.TENNIS_DOUBLES);
        courtRepository.save(court);
        return court;
    }


}
