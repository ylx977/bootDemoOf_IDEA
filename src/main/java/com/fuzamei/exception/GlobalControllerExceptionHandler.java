package com.fuzamei.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuzamei on 2018/4/16.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 全局异常处理的要比局部的异常处理的优先级别低，如果controller已经有了exceptionHandler，就优先使用controller里面的
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandle(HttpServletRequest request, HttpServletResponse response, Exception ex){
        return ex.getMessage()+"全局的";
    }
}
