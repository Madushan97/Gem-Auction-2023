package com.madushan.Gem.Auction.controller;

import com.madushan.Gem.Auction.bean.CommonResponseBean;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<CommonResponseBean> getAllUsers() {
        CommonResponseBean commonResponseBean = userService.getAllUsers();
        return ResponseEntity.ok(commonResponseBean);
    }
}
