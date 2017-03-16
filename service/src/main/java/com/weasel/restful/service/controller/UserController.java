package com.weasel.restful.service.controller;

import com.weasel.restful.service.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/3/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @ResponseBody
    @RequestMapping(value = {""},method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public List<User> users(HttpServletRequest request){
        return Arrays.asList(new User(1),new User(2));
    }

    @ResponseBody
    @RequestMapping(value = {"/{id}"},method = RequestMethod.GET,produces = {"application/json;charset=utf-8"},headers = {"Accept=application/json"})
    public User user(@PathVariable("id") long id,HttpServletRequest request){
        return new User(id);
    }

    @ResponseBody
    @RequestMapping(value = {""},method = RequestMethod.POST,consumes = {"application/json"},produces = {"application/json;charset=utf-8"},headers = {"Accept=application/json"})
    public User create(User user,HttpServletRequest request){
        return user;
    }

    @ResponseBody
    @RequestMapping(value = {"/{id}"},method = RequestMethod.DELETE,produces = {"application/json;charset=utf-8"},headers = {"Accept=application/json"})
    public User delete(@PathVariable("id") long id,HttpServletRequest request){
        return new User(id);
    }

    @ResponseBody
    @RequestMapping(value = {"/{id}"},method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json;charset=utf-8"},headers = {"Accept=application/json"})
    public User update(@PathVariable("id") long id,User user,HttpServletRequest request){
        user.setId(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = {"/{id}"},method = RequestMethod.PATCH,consumes = {"application/json"},produces = {"application/json;charset=utf-8"},headers = {"Accept=application/json"})
    public User portionUpate(@PathVariable("id") long id,User user,HttpServletRequest request){
        user.setId(id);
        return user;
    }
}
