package com.heu.lanke.scra.base.controller;

import com.heu.lanke.scra.base.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicController {

    @ExceptionHandler
    @ResponseBody
    public Response handleException(Exception e) {
        String message = e.toString();
        if (e.toString().contains("CustomException")) {
            message = e.getMessage();
        }
        if (e.toString().contains("MethodArgumentNotValidException")) {
            String rex = "\\[.*?\\]";
            Matcher matcher = Pattern.compile(rex).matcher(e.toString());
            while (matcher.find()) {
                String temp = matcher.group();
                message = temp.substring(1, temp.length() - 1);
            }
        }
        return fail(message, null);
    }

    protected Response fail(String message, Object object) {
        Response response = new Response();
        response.setStatus(Boolean.FALSE);
        response.setMessage(message);
        response.setResult(object);
        return response;
    }

    protected Response success(Object object) {
        Response response = new Response();
        response.setStatus(Boolean.TRUE);
        response.setResult(object);
        response.setMessage("success");

        return response;
    }
}
