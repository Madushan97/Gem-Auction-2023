package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.bean.CommonResponseBean;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.model.User;
import com.madushan.Gem.Auction.repository.UserRepository;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CommonResponseBean getAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList != null) {
            List<UserResponseDto> userResponseDtoList = new ArrayList<>();
            for (User user : userList) {
                UserResponseDto userResponseDto = new UserResponseDto();
                userResponseDto.setId(user.getId());
                userResponseDto.setUsername(user.getUsername());
                userResponseDto.setEmail(user.getEmail());
                userResponseDto.setPassword(user.getPassword());
                userResponseDto.setAddress(user.getAddress());
                userResponseDto.setPhoneNumber(user.getPhoneNumber());
                userResponseDto.setStatus(user.getStatus());
                userResponseDto.setAuction(user.getAuction());
                userResponseDto.setCreatedAt(user.getCreatedAt());
                userResponseDto.setUpdatedAt(user.getUpdatedAt());
                userResponseDtoList.add(userResponseDto);
            }
            CommonResponseBean commonResponseBean = new CommonResponseBean();
            commonResponseBean.setResponseCode(HttpStatus.OK.value());
            commonResponseBean.setResponseDescription("User successfully fetched");
            return commonResponseBean;

        } else {
            CommonResponseBean commonResponseBean = new CommonResponseBean();
            commonResponseBean.setResponseCode(HttpStatus.NO_CONTENT.value());
            commonResponseBean.setResponseDescription("No Resource found");
        }
        return null;
    }
}
