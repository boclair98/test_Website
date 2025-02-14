package com.example.CarSite.Controller;

import com.example.CarSite.Dto.UserDto;
import com.example.CarSite.Entity.User;
import com.example.CarSite.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.Optional;
@Controller
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    @PostMapping("/login")
    public String logins(Model model, UserDto userDto, @RequestParam("email") String emails,
                                                        @RequestParam("password") String password, HttpSession session){
        UserDto userDto1 = userService.findByEmail(userDto);
        if(userDto1!=null){
            model.addAttribute("name",userDto1.getEmail());
            model.addAttribute("username",userDto1.getName());
            session.setAttribute("name",userDto1.getEmail());
            session.setAttribute("username",userDto1.getName());
            session.setMaxInactiveInterval(1800);
            System.out.println(emails);
            System.out.println(password);
            log.info("name={}, username={} ",emails,password);
            return "index2";
        }else{
            model.addAttribute("erroremail","아이디 혹은 비밀번호가 잘못 입력 되었습니다");
            return "user/login";
        }
    }
    @GetMapping("/join")
    public String join(){
        return "user/join";
    }
    @PostMapping("/join")
    public String joins(User user, Model model){
        UserDto userDto = UserDto.userDto(user);
        if(userService.existByEmail(userDto.getEmail())){
            model.addAttribute("errorname","동일한 ID가 존재합니다.");
            return "user/join";
        }else{
            userService.join(userDto);
        }

        return "index";
    }

}
