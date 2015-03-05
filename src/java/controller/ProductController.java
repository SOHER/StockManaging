/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.DaoGeneric;
import dao.FactoryDao;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Ball;
import model.Category;
import model.Employee;
import model.Product;
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
@SessionAttributes(value = "employe,lCats")
@RequestMapping(value = "/products")
public class ProductController {
    
        @RequestMapping(value = "/products", method = RequestMethod.POST)
        public String productsPost(@ModelAttribute (value = "employe")Employee employee, HttpSession session) {
        session.setAttribute("employe", employee);
        return "products"; 
        }
        
        @RequestMapping(value = "/products", method = RequestMethod.GET)
        public String productsGET(@ModelAttribute (value = "employe")Employee employee, HttpSession session) {
        session.setAttribute("employe", employee);
        return "products"; 
        }
        
        @RequestMapping(value = "/football", method = RequestMethod.GET)
        public String footballGet() {
        return "football"; 
        }
        
        @RequestMapping(value = "/tennis", method = RequestMethod.GET)
        public String tennisGet() {
        return "tennis"; 
        }
        @RequestMapping(value = "/basketball", method = RequestMethod.GET)
        public String basketballGet() {
        return "basketball"; 
        }
        @RequestMapping(value = "/ping_pong", method = RequestMethod.GET)
        public String pingpongGet() {
        return "ping_pong"; 
        }
        
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String signinPost(Model model) {
        model.addAttribute("productNew", new Ball());
        return "addProduct";    
    }
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String signinGet(Model model) {
        model.addAttribute("productNew", new Ball());
        return "addProduct";
    }
        
        
    
    
        
    @ModelAttribute(value = "lCats")
    public List<Category> listeEditeurs(){
    DaoGeneric dao = FactoryDao.getDAO("Category");
    List<Category> cats = dao.selectAll();
    return cats;
    }
    
    
}
