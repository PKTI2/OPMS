package pl.opms.fe.controller.round;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.opms.be.entity.PatientEntity;
import pl.opms.be.entity.QPatientEntity;
import pl.opms.be.entity.RoomEntity;
import pl.opms.be.service.PatientService;
import pl.opms.be.service.RoomService;
import pl.opms.be.utils.CollectionUtils;

import java.util.Collection;

/**
 * Created by Piotr Borczyk on 09.01.2017.
 */

@Controller
@RequestMapping(value = "/round/room")
public class RoomController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(path = "")
    public String room(@RequestParam(required = false) Long id,
                       ModelMap modelMap){
        RoomEntity roomEntity = roomService.findOne(id);
        QPatientEntity qPatientEntity = QPatientEntity.patientEntity;

        BooleanExpression searchPredicate = qPatientEntity.patientData.room.id.eq(id);
        Collection<PatientEntity> patients = CollectionUtils.toCollection(patientService.findAll(searchPredicate));
        modelMap.addAttribute("patients",patients);
        modelMap.addAttribute("room",roomEntity);
        return "round/room";
    }
}
