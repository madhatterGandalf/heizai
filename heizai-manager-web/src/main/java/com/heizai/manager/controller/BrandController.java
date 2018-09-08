package com.heizai.manager.controller;


import com.heizai.pojo.TbBrand;
import com.heizai.sellergoods.service.BrandService;
import com.heizai.util.PageResultUtil;
import com.heizai.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     *  查询所有品牌
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<TbBrand> findAll(){
       return brandService.findAll();
    }

    /**
     *  分页查询品牌数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/page",method = RequestMethod.GET)
    public PageResultUtil findByPage(@RequestParam(name = "pagenum",defaultValue = "0",required = true) int pageNum,
    @RequestParam(name = "pagesize",defaultValue = "5",required = true) int pageSize){
        return brandService.findByPage(pageNum,pageSize);
    }

    /**
     *  添加一个新的品牌
     * @param brand
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public ResultUtil add(@RequestBody TbBrand brand){
        Long key = brandService.add(brand);
        ResultUtil result = new ResultUtil();
        if (key != 0){
            result.setStatus(true);
            result.setMessage("ok");
        }else{
            result.setStatus(false);
            result.setMessage("error");
        }
        return result;
    }

    /**
     * 根据ID 查询品牌
     * @param id
     * @return
     */
    @RequestMapping(value = "/key",method = RequestMethod.GET)
    public ResultUtil selectKey(@RequestParam(name = "key",required = true)Long id){
        ResultUtil result = new ResultUtil();
        if (id == null){
            result.setStatus(false);
            result.setMessage("key不能为空");
            return result;
        }
        TbBrand brand = brandService.selectKey(id);

        if (brand.getId() != null){
            result.setStatus(true);
            result.setMessage("ok");
            result.setResultData(brand);
        }else{
            result.setStatus(false);
            result.setMessage("查询不到数据!");
            return result;
        }
        return result;
    }

    /**
     *  按id更新品牌信息
     * @param brand
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public ResultUtil update(@RequestBody TbBrand brand){
        ResultUtil result = new ResultUtil();
        if (brand.getId() == null){
            result.setStatus(false);
            result.setMessage("key不能为空");
            return result;
        }
        Integer rows = brandService.update(brand);

        if (rows != null && rows > 0){
            result.setStatus(true);
            result.setMessage("ok");
        }else{
            result.setStatus(false);
            result.setMessage("更新数据失败!");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResultUtil delete(@RequestParam(name = "keys")Integer[] ids){
        ResultUtil result = new ResultUtil();
        if (ids == null || ids.length == 0){
            result.setStatus(false);
            result.setMessage("id值为空");
            return result;
        }
        Integer rows = brandService.delete(ids);

        if (rows != null && rows > 0){
            result.setStatus(true);
            result.setMessage("ok");
        }else{
            result.setStatus(false);
            result.setMessage("更新数据失败!");
            return result;
        }
        return result;
    }

}
