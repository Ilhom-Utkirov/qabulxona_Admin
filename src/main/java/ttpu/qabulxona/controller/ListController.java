package ttpu.qabulxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ttpu.qabulxona.entity.Appeal;
import ttpu.qabulxona.entity.vm.AppealVM;
import ttpu.qabulxona.repository.AppealRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Controller
@RequestMapping(value = "/")
public class ListController {
    @Autowired
    private AppealRepository appealRepository;

    @RequestMapping(value = "")
    public String get() {

        return "appealList";
    }

    @RequestMapping(value = "appeals/ajax_list")
    @ResponseBody
    public HashMap<String, Object> getUsersAsJSON() {
        List<Appeal> appealList;
        appealList= appealRepository.findAll();
        HashMap<String, Object> result = new HashMap<>();
        List<Object[]> convenientForJSONArray = new ArrayList<>(appealList.size());

        for(Appeal appeal: appealList) {
            convenientForJSONArray.add(new Object[] {
                    appeal.getId(),
                    appeal.getName(),
                    appeal.getSurname(),
                    appeal.getPhoneNumber(),
                    appeal.getStudentId(),
                    appeal.getStudentEmail(),
                    //appeal.getAppaelText(),
                    appeal.getAppealType(),
                    appeal.getDateCreated()

            });
        }
        result.put("data", convenientForJSONArray);
        return result;
    }

    @RequestMapping(value = "/appeals/details",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> showModal(@RequestParam(value = "id") Integer id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Map<String, Object> result = new HashMap<>();

        Appeal appeal = appealRepository.findOne(id);
        AppealVM vm = new AppealVM();

        vm.setId(appeal.getId());
        vm.setName(appeal.getName());
        vm.setSurname(appeal.getSurname());
        vm.setPhoneNumber(appeal.getPhoneNumber());
        vm.setStudentEmail(appeal.getStudentEmail());
        vm.setStudentId(appeal.getStudentId());
        vm.setAppaelText(appeal.getAppaelText());
        vm.setAppealType(appeal.getAppealType());
        vm.setDateCreated(appeal.getDateCreated()== null ? "--/--/----" :dateFormat.format(appeal.getDateCreated()));


        result.put("details", vm);
        return result;
    }

}
