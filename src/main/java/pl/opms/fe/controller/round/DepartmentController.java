package pl.opms.fe.controller.round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.opms.be.entity.DepartmentEntity;
import pl.opms.be.entity.RoomEntity;
import pl.opms.be.repository.DepartmentRepository;
import pl.opms.be.repository.RoomRepository;
import pl.opms.be.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by howor on 08.01.2017.
 */

@Controller
@RequestMapping(value = "/round/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(path = "")
    public String root(@RequestParam(required = false) Long id,
                       ModelMap modelMap) {
//        List<RoomEntity> roomEntityList = new ArrayList<>();
//        DepartmentEntity departmentEntity = new DepartmentEntity(roomEntityList,"TEST");
//        RoomEntity roomEntity = new RoomEntity(12,11,201,"never see you",departmentEntity);
//        RoomEntity roomEntity1 = new RoomEntity(12,6,202,"never see you anymore",departmentEntity);
//        roomEntityList.add(roomEntity);
//        roomEntityList.add(roomEntity1);
//        roomRepository.save(roomEntity);
//        roomRepository.save(roomEntity1);
//        departmentRepository.save(departmentEntity);
        DepartmentEntity department = departmentService.findOne(id);
        modelMap.addAttribute("department",department);
        modelMap.addAttribute("rooms",department.getRooms());
        return "round/department";
    }
}
