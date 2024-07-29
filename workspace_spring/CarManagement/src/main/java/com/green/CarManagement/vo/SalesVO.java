package com.green.CarManagement.vo;

import lombok.Data;

@Data
public class SalesVO {
    private int saleNum;
    private String buyerName;
    private String buyerTel;
    private String color;
    private String saleDate;
    private int carNum;
    private CarVO carVO;
}
