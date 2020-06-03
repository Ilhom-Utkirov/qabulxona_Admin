package ttpu.qabulxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ttpu.qabulxona.entity.Appeal;
import ttpu.qabulxona.repository.AppealRepository;

import java.sql.Timestamp;
import java.util.Date;



/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Controller
public class MainController {

//    @Autowired
//    private AppealRepository appealRepository;
//
//    @RequestMapping("/")
//    public String get(Model model) {
//     Appeal appeal = new Appeal();
//     model.addAttribute("appeal",appeal);
//     return "index";
//    }
//
//    @RequestMapping(value = "/appeal/save", method = RequestMethod.POST )
//    public String saveAppaal(Appeal appeal) {
//        Date date = new Date();
//        appeal.setDateCreated(new Timestamp(date.getTime()));
//         appealRepository.save(appeal);
//
//        return "redirect:/" ;
//    }



}
