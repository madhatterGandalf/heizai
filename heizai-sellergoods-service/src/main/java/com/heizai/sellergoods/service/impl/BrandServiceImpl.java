package com.heizai.sellergoods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heizai.mapper.TbBrandMapper;
import com.heizai.pojo.TbBrand;
import com.heizai.pojo.TbBrandExample;
import com.heizai.sellergoods.service.BrandService;
import com.heizai.util.PageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResultUtil findByPage(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<TbBrand> brandList = brandMapper.selectByExample(null);
        PageResultUtil pageResultUtil = new PageResultUtil();
        pageResultUtil.setPageNum(pageNum);
        pageResultUtil.setPageSize(pageSize);
        pageResultUtil.setRows(brandList);
        pageResultUtil.setTotal(page.getTotal());

        return pageResultUtil;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public Long add(TbBrand brand) {
        brandMapper.insert(brand);
        return brand.getId();
    }

    @Override
    public TbBrand selectKey(Long id) {
        TbBrand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer update(TbBrand brand) {
        Integer rows = brandMapper.updateByPrimaryKey(brand);
        return rows;
    }

    @Override
    public Integer delete(Integer[] ids) {
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        List idList = Arrays.asList(ids);
        criteria.andIdIn(idList);
        Integer rows = brandMapper.deleteByExample(example);
        return rows;
    }
}
