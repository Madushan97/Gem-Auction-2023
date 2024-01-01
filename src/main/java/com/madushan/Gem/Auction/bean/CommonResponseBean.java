package com.madushan.Gem.Auction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponseBean {

    private int responseCode;
    private String responseDescription;
    private Object data;
}
