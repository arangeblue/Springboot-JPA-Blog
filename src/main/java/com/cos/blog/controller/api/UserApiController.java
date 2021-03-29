package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {
    

    @Autowired
    private UserService userService;


    @PostMapping("auth/joinProc") // 조인 실행
    public ResponseDto<Integer> save(@RequestBody User user) {  // username, password, email
        System.out.println("UserApiController: save 호출 됨");
        // 실제로 db에 insert를 하고 아래에서 return이 되면 된다.
        userService.회원가입(user); // 성공 시 1, 실패 시 -1
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 json으로 변환해서 리턴(Jackson)
    };

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user, Model model) { //key=value, x-www-form-urlencoded @RequestBody
        userService.회원수정(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    };













    
    // 전통적인 login 방식
    // @PostMapping("/api/user/login")
    // public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
    //     System.out.println("UserApiController: login 호출 됨");
    //     User principal = userService.로그인(user); // principal (접근 주체)
    //     if(principal != null){
    //         session.setAttribute("principal", principal);
    //     }
    //     return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    // }
}