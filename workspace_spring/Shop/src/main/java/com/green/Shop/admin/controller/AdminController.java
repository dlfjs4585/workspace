package com.green.Shop.admin.controller;

import com.green.Shop.admin.service.AdminService;
import com.green.Shop.item.vo.CategoryVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api_admin")
public class AdminController {
    @Resource(name = "adminService")
    private AdminService adminService;

    @GetMapping("/getCateList")
    public List<CategoryVO> getCategoryList(){
        return adminService.getCategoryList();
    }

}
