package com.madushan.Gem.Auction.service.impl;

import com.madushan.Gem.Auction.bean.CommonResponseBean;
import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;
import com.madushan.Gem.Auction.dto.responseDto.UserResponseDto;
import com.madushan.Gem.Auction.model.User;
import com.madushan.Gem.Auction.repository.UserRepository;
import com.madushan.Gem.Auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            commonResponseBean.setResponseDescription("Users successfully fetched");
            commonResponseBean.setData(userResponseDtoList);
            return commonResponseBean;

        } else {
            CommonResponseBean commonResponseBean = new CommonResponseBean();
            commonResponseBean.setResponseCode(HttpStatus.NO_CONTENT.value());
            commonResponseBean.setResponseDescription("No Resource found");
        }
        return null;
    }

    @Override
    public CommonResponseBean getUserById(int userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
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

            CommonResponseBean commonResponseBean = new CommonResponseBean();
            commonResponseBean.setResponseCode(HttpStatus.OK.value());
            commonResponseBean.setResponseDescription("User successfully fetched");
            commonResponseBean.setData(userResponseDto);
            return commonResponseBean;
        } else {
            CommonResponseBean commonResponseBean = new CommonResponseBean();
            commonResponseBean.setResponseCode(HttpStatus.NO_CONTENT.value());
            commonResponseBean.setResponseDescription("Resource not found");
            return commonResponseBean;
        }

    }

    @Override
    public CommonResponseBean createUser(UserRequestDto userRequestDto) {

        User user = new User();
        user.setId(userRequestDto.getId());
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setAddress(userRequestDto.getAddress());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setStatus(userRequestDto.getStatus());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        CommonResponseBean commonResponseBean = new CommonResponseBean();
        commonResponseBean.setResponseCode(HttpStatus.OK.value());
        commonResponseBean.setResponseDescription("User successfully saved");
        commonResponseBean.setData(user);
        return commonResponseBean;
    }

    @Override
    public CommonResponseBean deleteUser(int userId) {
        try {
            if (userRepository.existsById(userId)) {
                userRepository.deleteById(userId);

                CommonResponseBean commonResponseBean = new CommonResponseBean();
                commonResponseBean.setResponseCode(HttpStatus.OK.value());
                commonResponseBean.setResponseDescription("User successfully deleted");
                commonResponseBean.setData(null);
                return commonResponseBean;

            } else {
                CommonResponseBean commonResponseBean = new CommonResponseBean();
                commonResponseBean.setResponseCode(HttpStatus.NOT_FOUND.value());
                commonResponseBean.setResponseDescription("User ID : " + userId + " not found");
                return commonResponseBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
