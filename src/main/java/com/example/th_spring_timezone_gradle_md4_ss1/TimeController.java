package com.example.th_spring_timezone_gradle_md4_ss1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        // lấy ra timezone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);
        //Tính thời gian hiện tại của một thành phố cụ thể
        Long locateTime = date.getTime() + (locale.getRawOffset()- local.getRawOffset());
        // cài đặt lại thời gian cho biến date thành thời gian hiên tại của 1 thành phố cụ thể
        date.setTime(locateTime);
        // chuyển dữ liệu và gửi qua view
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);

        return "index";

    }
}
