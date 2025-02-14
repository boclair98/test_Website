package com.example.CarSite.Controller.Hyundai;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class Main {

    @GetMapping("/hyundai/information")
    public String home() {
        return "Pratice/Hyundai";
    }

    @RequestMapping(value = "/https://your-app-url.com/callback") //설정한 redirect_uri에 맞게 정의
    public void account(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state, HttpServletResponse response) throws IOException {

        String requestState = "{randomstate123}"; //request로 설정한 state와 동일한 값
        String redirectURL = "{https://your-app-url.com/callback}";


        // SUCCESS 200 Response code, state
        System.out.println("RESPONSE_STATE = " + state);
        System.out.println("RESPONSE_CODE = " + code);


        // state 검증
        if (!state.equals(requestState)) {
            System.out.println(state + " 유효하지 않은 state 응답입니다.");
            return;
        }
    }
}
