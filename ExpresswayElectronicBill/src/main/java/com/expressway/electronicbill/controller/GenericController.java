package com.expressway.electronicbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用控制器
 * 
 * @author Ajaxfan
 */
@Controller
public class GenericController {
    /**
     * @return 主页面
     */
    @RequestMapping(value = { "/", "index" })
    public String index() {
        return "index";
    }

    /**
     * @param path
     * 
     * @return 系统内部页面跳转
     */
    @RequestMapping(value = "{path}")
    public String forward(@PathVariable("path") String path) {
        return path;
    }
}
