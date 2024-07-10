package com.green.AxiosTest;

import lombok.Data;

@Data
public class ItemVO {
    private int itemNum;
    private String itemName;
    private int price;
    private String intro;
    private String imgName;

    public ItemVO(int itemNum, String itemName, int price, String intro, String imgName) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.price = price;
        this.intro = intro;
        this.imgName = imgName;
    }
}
