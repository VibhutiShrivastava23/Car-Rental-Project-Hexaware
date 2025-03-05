package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value="/login/{email}/{password}")
    public int login(@PathVariable String email, @PathVariable String password) {
        int result = adminService.login(email, password);
        System.out.println("Controller Count  " + result);
        return result;
    }

    @GetMapping(value = "/showAdmin")
    public List<Admin> showAdmin() {
        return adminService.showAdmin();
    }

    @PostMapping(value = "/addAdmin")
    public void addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
    }

    @GetMapping("/report/revenue/{carid}")
    public Optional<Double> getRevenueByCar(@PathVariable int carid) {
        return adminService.getRevenueByCarId(carid);
    }
}
