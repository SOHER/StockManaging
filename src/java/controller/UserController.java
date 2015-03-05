/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.DaoGeneric;
import dao.FactoryDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@SessionAttributes(value = "lEmployees,employeMod")
@RequestMapping(value = "/user")
public class UserController {
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute (value = "employeNew")Employee employee, Model model, HttpSession session) {
        if(session.getAttribute("employe")!= null)
        {
            session.removeAttribute("employe");
            model.addAttribute("employe", new Employee());
        }
        if(employee!=null)
        {
         DaoGeneric dao = FactoryDao.getDAO("Employee");
         dao.insert(employee);
        }
        model.addAttribute("employe", new Employee());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model, HttpSession session) {
        if(session.getAttribute("employe")!= null)
        {
            session.removeAttribute("employe");
            model.addAttribute("employe", new Employee());
        }
        model.addAttribute("employe", new Employee());
        return "login";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signinPost(Model model) {
        model.addAttribute("employeNew", new Employee());
        return "signin";    
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signinGet(Model model) {
        model.addAttribute("employeNew", new Employee());
        return "signin";      }
    
    
    @RequestMapping(value = "/managingEmployee", method = RequestMethod.GET)
    public String managing() {
        return "managingEmployee";
    }
    
    @RequestMapping(value = "managingEmployee/modifyEmployee", method = RequestMethod.GET)
    public String modifyEmployeeGet(@ModelAttribute (value = "employe")Employee employee, HttpServletRequest request, Model model) {
        String idd = request.getParameter("id");
        DaoGeneric dao = FactoryDao.getDAO("Employee");
        int idMod = Integer.parseInt(request.getParameter("id"));
        Employee emMod = dao.selectById(idMod);
        model.addAttribute("employeMod", emMod);
        return "modifyEmployee";
    }
    @RequestMapping(value = "managingEmployee/modifyEmployee", method = RequestMethod.POST)
    public String modifyEmployeePost(@ModelAttribute (value = "employe")Employee employee, HttpServletRequest request, Model model) {
        String idd = request.getParameter("id");
        DaoGeneric dao = FactoryDao.getDAO("Employee");
        int idMod = Integer.parseInt(request.getParameter("id"));
        Employee emMod = dao.selectById(idMod);
        model.addAttribute("employeMod", emMod);
        return "modifyEmployee";
    }

    /**
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String getEmployee(@ModelAttribute (value = "employe")Employee employee, HttpSession session) {
        DaoGeneric dao = FactoryDao.getDAO("Employee");
        Employee em = dao.connectByLogin(employee.getMail(),employee.getPassword());
        session.setAttribute("employe", em);
        return "welcome";
    }
    /**
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "managingEmployee/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute (value = "employeMod")Employee employee, HttpServletRequest request, Model model) {
        DaoGeneric dao = FactoryDao.getDAO("Employee");
        dao.update(employee);
        return "managingEmployee";
    }
    
    /**
     *
     * @return 
     */
    @ModelAttribute(value = "lEmployees")
    public List<Employee> listEmployees(){
    DaoGeneric dao = FactoryDao.getDAO("Employee");
    List<Employee> e = dao.selectAll();
    return e;
}
//    
//    @ModelAttribute(value = "lEditeurs")
//    public List<Editeurs> listeEditeurs(){
//    DaoGeneric dao = FactoryDao.getDAO("Editeurs");
//    List<Editeurs> e = dao.selectAll();
//    return e;
//    }
    
}
