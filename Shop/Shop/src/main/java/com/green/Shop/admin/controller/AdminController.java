package com.green.Shop.admin.controller;

import com.green.Shop.admin.service.AdminService;
import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_admin")
public class AdminController {
    @Resource(name = "adminService")
    private AdminService adminService;

    @GetMapping("/getCategoryList")
    public List<CategoryVO> getCategoryList(){
        return adminService.getCategoryList();
    }

    @PostMapping("/insertItem")
    public void insertItem(@RequestBody ItemVO itemVO){
        adminService.insertItem(itemVO);
    }

    @GetMapping("/getItemList")
    public List<ItemVO> getItemList(){
        return adminService.getItemList();
    }

}
