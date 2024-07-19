package com.green.ReactItem.controller;

import com.green.ReactItem.service.ItemService;
import com.green.ReactItem.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Resource(name = "itemService")
    private ItemService itemService;

    @GetMapping("/itemInfo")
    public List<ItemVO> getItemInfo(){
        return itemService.getItemInfo();
    }

    @GetMapping("/getItemDetail/{itemNum}")
    public ItemVO getItemDetail(@PathVariable("itemNum") int itemNum){
        return itemService.getItemDetail(itemNum);
    }

    @PutMapping("/updateItem/{itemNum}")
    public void updateItem(@RequestBody ItemVO itemVO){
        itemService.updateItem(itemVO);
        System.out.println(itemVO);
    }

    @PostMapping("/insertItem")
    public void regItem(@RequestBody ItemVO itemVO){
        itemService.regItem(itemVO);
    }



}
