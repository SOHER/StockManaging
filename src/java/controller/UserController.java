/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.DaoGeneric;
import dao.FactoryDao;
import java.util.List;
import model.Client;
import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Emile
 */
@Controller
@SessionAttributes(value = "user")
@RequestMapping(value = "/user")
public class UserController {
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model) {
        
        model.addAttribute("user", new Employee());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model) {
        
        model.addAttribute("user", new Employee());
        return "login";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signinPost() {
        return "signin";
    }
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signinGet() {
        return "signin";
    }

    /**
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String getEmployee(@ModelAttribute (value = "user")Employee employee, Model model) {
        DaoGeneric dao = FactoryDao.getDAO("Employee");
        Employee em = dao.connectByLogin(employee.getMail(),employee.getPassword());
        model.addAttribute("user", em);
        return "welcome";
    }
    
//    /**
//     *
//     * @return 
//     */
//    @ModelAttribute(value = "lVilles")
//    public List<Villes> listeVille(){
//    DaoGeneric dao = FactoryDao.getDAO("Villes");
//    List<Villes> l = dao.selectAll();
//    return l;
//}
//    
//    @ModelAttribute(value = "lEditeurs")
//    public List<Editeurs> listeEditeurs(){
//    DaoGeneric dao = FactoryDao.getDAO("Editeurs");
//    List<Editeurs> e = dao.selectAll();
//    return e;
//    }
    
}
