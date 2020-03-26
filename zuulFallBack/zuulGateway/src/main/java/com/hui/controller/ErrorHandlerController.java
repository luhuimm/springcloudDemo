package com.hui.controller;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public Map<String, Object> error(HttpServletRequest httpServletRequest) {
        Map<String, Object> errorAttris = getErrorAttributes(httpServletRequest);

//        String msg = (String) errorAttris.get("message");
//        String trace = (String) errorAttris.get("trace");
//        if(StringUtils.isNotBlank(trace)) {
//            msg += String.format(" and trace %s ", trace);
        //}
        return errorAttris;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest httpServletRequest) {

       return errorAttributes.getErrorAttributes(new ServletWebRequest(httpServletRequest),
                true);
    }

}
