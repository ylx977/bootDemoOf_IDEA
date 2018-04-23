package com.fuzamei.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuzamei on 2018/4/16.
 */
//@ResponseBody//如果主controller加了restController就不用加这个了
public class BaseController {

    /**
     * 局部异常处理的要比全局的异常处理的优先级别更高
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandle(HttpServletRequest request, HttpServletResponse response, Exception ex){
        return ex.getMessage()+"局部的";
    }

}
