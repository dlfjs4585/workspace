package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.item.vo.CartVO;
import com.green.Shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_item")
public class ItemController {
    @Resource(name = "itemService")
    private ItemService itemService;

    @GetMapping("/getItemList")
    public List<ItemVO> getItemList(){
        return itemService.getItemList();
    }

    @GetMapping("/getItemDetail/{itemCode}")
    public ItemVO getItemDetail(@PathVariable("itemCode") int itemCode){
        return itemService.getItemDetail(itemCode);
    }

    @PostMapping("/insertCart")
    public void insertCart(@RequestBody CartVO cartVO){
        itemService.insertCart(cartVO);
    }

    @GetMapping("/getCartList")
    public List<CartVO> getCartList(){
        return itemService.getCartList();
    }

}
