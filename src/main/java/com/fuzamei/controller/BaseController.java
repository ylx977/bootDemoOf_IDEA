package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzamei on 2018/4/16.
 */
@ControllerAdvice
@ResponseBody
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

    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception) throws Exception {
        //按需重新封装需要返回的错误信息
        List<String> invalidArguments = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            invalidArguments.add(error.getField()+"/"+error.getDefaultMessage()+error.getRejectedValue());
        }
        JsonBean jsonBean = new JsonBean();
        jsonBean.setList(invalidArguments);
        return jsonBean;
    }


}
