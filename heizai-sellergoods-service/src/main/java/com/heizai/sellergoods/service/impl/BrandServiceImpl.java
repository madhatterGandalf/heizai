package com.heizai.sellergoods.service.impl;

import com.heizai.mapper.TbBrandMapper;
import com.heizai.pojo.TbBrand;
import com.heizai.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }
}
