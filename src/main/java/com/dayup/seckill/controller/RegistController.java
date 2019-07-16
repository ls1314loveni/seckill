package com.dayup.seckill.controller;

import com.dayup.seckill.entity.User;
import com.dayup.seckill.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RegistController {

    @Autowired
    private UserServices userServices;

    private static Logger log = LoggerFactory.getLogger(RegistController.class);
    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView toRegister(ModelMap model) {
        User user = new User();
        return new ModelAndView("register").addObject(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult) {
        log.info("username=" + user.getUsername() + ",password=" + user.getPassword());
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        user.setId(2018);
        User newUser = userServices.regist(user);
        if (newUser != null) {
            return new ModelAndView("register");
        } else {
            return new ModelAndView("register");
        }
    }

}
