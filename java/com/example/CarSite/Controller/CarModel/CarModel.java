package com.example.CarSite.Controller.CarModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarModel {

    @GetMapping("/car/model")
    public String model(){
        return "car/model";
    }
}
