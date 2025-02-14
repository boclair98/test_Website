package com.example.CarSite.Controller.Search;

import com.example.CarSite.Dto.UserDto;
import com.example.CarSite.Entity.User;
import com.example.CarSite.Service.SeachService;
import com.example.CarSite.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class Id {
    @Autowired
    private UserService userService;
    @Autowired
    private SeachService seachService;

    @GetMapping("/searchid")
    public String searchId() {
        return "search/searchid";
    }

    @PostMapping("/searchid")
    public String searchid(Model model, @ModelAttribute UserDto userDto, HttpServletRequest request) {
        String phonenumber = request.getParameter("phonenumber");
        String name = request.getParameter("name");
        Optional<User> users = seachService.findByName(name);
        if(users.isPresent()){
            User user = users.get();
            if(phonenumber.equals(user.getPhonenumber())){
                System.out.println(user.getEmail());
                model.addAttribute("name",name);
                model.addAttribute("email",user.getEmail());
            }else{
                model.addAttribute("name","회원님의");
                model.addAttribute("email","정보가 없습니다.");
            }
        }else{
            model.addAttribute("name","회원님의");
            model.addAttribute("email","정보가 없습니다.");
        }
        return"search/id";
    }

    @PostMapping("/search")
    public String search(HttpServletRequest request,Model model,HttpSession session){
        String search = request.getParameter("search");
//        System.out.println(session.getAttribute("name"));
//        System.out.println(session.getAttribute("username"));

        if(search.equals("전기자동차") || search.equals("전기차")){
            model.addAttribute("usernames",session.getAttribute("username"));
            return "carmodel/electriccar";
        }
        return"";
    }
}
