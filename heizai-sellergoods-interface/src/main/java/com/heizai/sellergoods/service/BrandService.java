package com.heizai.sellergoods.service;

import com.heizai.pojo.TbBrand;
import com.heizai.util.PageResultUtil;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 分页查询品牌数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResultUtil findByPage(int pageNum, int pageSize);

    /**
     * 添加数据
     * @param brand
     * @return
     */
    Long add(TbBrand brand);

    /**
     * 根据品牌id查询品牌
     * @param id
     * @return
     */
    TbBrand selectKey(Long id);

    /**
     * 按id更新数据
     * @param brand
     * @return
     */
    Integer update(TbBrand brand);

    Integer delete(Integer[] ids);
}
