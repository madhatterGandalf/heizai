package com.heizai.manager.controller;


import com.heizai.pojo.TbBrand;
import com.heizai.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<TbBrand> findAll(){
       return brandService.findAll();
    }

}
