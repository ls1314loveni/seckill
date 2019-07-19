package com.dayup.seckill.controller;

import com.dayup.seckill.entity.User;
import com.dayup.seckill.services.UserServices;
import com.dayup.seckill.utils.ValidateCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;


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
    public String toRegister() {
        return "register";
    }

    /**
     * 注册成功
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult) {
        log.info("username=" + user.getUsername() + ",password=" + user.getPassword());
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        user.setId(2018);
        int regist = userServices.regist(user);
        if (regist > 0) {
            return new ModelAndView("register");
        } else {
            return new ModelAndView("error");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
       return "login";
    }

    @RequestMapping("/home")
    public String toHome(String username, String password, HttpSession session, String code) {
        String page = "";
        String seesionCode = (String) session.getAttribute("code");
        if (!StringUtils.containsIgnoreCase(code, seesionCode)) {
            session.setAttribute("message", "验证码错误");
            return "login";
        }
        if (username != null && password != null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user = userServices.findUser(user);
            if (user != null) {
                session.setAttribute("user", user);
                page = "home";
            } else {
                page = "login";
            }
        }
        return page;
    }

    @RequestMapping("/validateCode")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        // 禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();
        ValidateCode vCode = new ValidateCode(120,34,5,100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }
}
