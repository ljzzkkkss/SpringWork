package com.excelib.controller;

import com.excelib.daoimp.UserDaoImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by 刘骏 on 2016/8/23.
 */

@Controller
public class GoController {
    private final Log logger = LogFactory.getLog(GoController.class);

    private UserDaoImp userDaoImp = new UserDaoImp();

    //处理HEAD类型的"/"请求
    @RequestMapping(value = {"/"},method = {RequestMethod.HEAD})
    public String head() {
        return"go";
    }

    //处理GET类型的"/index"和"/"请求
    @RequestMapping(value={"/index","/"},method= {RequestMethod.GET})
    public String index(Model model) throws Exception {
        logger.info("=====processed by index======");
        //返回msg参数
        model.addAttribute("msg",userDaoImp.getUserByUsernameAndPassword("ljzzkkkss","123").getUsername());
        return "go";
    }
}
