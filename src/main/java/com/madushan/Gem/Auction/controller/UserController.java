package com.madushan.Gem.Auction.controller;

import com.madushan.Gem.Auction.bean.CommonResponseBean;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<CommonResponseBean> getAllUsers() {
        CommonResponseBean commonResponseBean = userService.getAllUsers();
        return ResponseEntity.ok(commonResponseBean);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseBean> getUserById(@PathVariable(value = "id")int userId) {
        CommonResponseBean commonResponseBean = userService.getUserById(userId);
        return ResponseEntity.ok(commonResponseBean);
    }
}
