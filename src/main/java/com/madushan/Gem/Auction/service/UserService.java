package com.madushan.Gem.Auction.service;

import com.madushan.Gem.Auction.bean.CommonResponseBean;
import com.madushan.Gem.Auction.dto.requestDto.UserRequestDto;

public interface UserService {

    CommonResponseBean getAllUsers();

    CommonResponseBean getUserById(int userId);

    CommonResponseBean createUser(UserRequestDto userRequestDto);

    CommonResponseBean deleteUser(int userId);
}
