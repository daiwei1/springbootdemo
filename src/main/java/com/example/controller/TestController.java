package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/hello")
    //@ResponseBody
    public ModelAndView test1(){
ModelAndView mv=new ModelAndView();
mv.setViewName("index.html");
        return mv;
    }

    @RequestMapping("/test3")
    public String test3(){

        return "hello";
    }

    @RequestMapping(value = "/test2",method = {RequestMethod.GET})
    @ResponseBody
    public Object test2(){
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        //cal_1.add(Calendar.MONTH, -1);//月份减一
        cal_1.set(Calendar.DAY_OF_MONTH,2);//设置为2号,当前日期既为本月第一天

        Calendar calendar = Calendar.getInstance();
       // calendar.setTime(new Date());
        Date date=calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("cal_1:"+sdf.format(cal_1.getTime()));
       String stringdate= sdf.format(date);
       calendar.add(Calendar.DAY_OF_MONTH,1);
       Date date2=calendar.getTime();
       System.out.println(date.before(date2));
       Map map=new HashMap();
       map.put("date",stringdate);
        return map;
    }
}
