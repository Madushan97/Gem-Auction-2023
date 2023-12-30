package com.madushan.Gem.Auction.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Boolean status;
}
