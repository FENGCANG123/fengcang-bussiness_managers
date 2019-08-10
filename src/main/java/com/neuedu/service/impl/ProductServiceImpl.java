package com.neuedu.service.impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> selectAll() {
        List<Product> productList=productMapper.selectAll();
        for (Product p:productList
             ) {
            System.out.println(p.getCreateTime().toString());
        }
        return productMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        if(record.getName()==null||record.getName().equals(""))
        {
            throw new MyException("商品名不能为空","");
        }
        if(record.getPrice()==null||record.getPrice().equals(""))
        {
            throw new MyException("商品名价格不能为空","");
        }
        if(record.getStock()==null||record.getStock().equals(""))
        {
            record.setStock(0);
        }
        int result=productMapper.exsitsProductname(record.getName());
        Product product=productMapper.selectByPrimaryKey(record.getId());
        if (result>0&&!product.getName().equals(record.getName()))
        {
            throw new MyException("商品名已存在","");
        }
        System.out.println("service==================="+record.getCategoryId());

         int r= productMapper.updateByPrimaryKey(record);
        System.out.println(r);
        return r;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record)throws MyException {
        if(record.getName()==null||record.getName().equals(""))
        {
            throw new MyException("商品名不能为空","");
        }
        if(record.getPrice()==null||record.getPrice().equals(""))
        {
            throw new MyException("商品名价格不能为空","");
        }
        if(record.getStock()==null||record.getStock().equals(""))
        {
            record.setStock(0);
        }
        int result=productMapper.exsitsProductname(record.getName());
        if (result>0)
        {
            throw new MyException("商品名已存在","");
        }
        return productMapper.insert(record);
    }

    @Override
    public List<String> subImages(String subImages) {
        List<String> sunImageslist=new ArrayList<>();
        String str=subImages;
        String[] strArr = str.split("\\,");
        for (String s:strArr
             ) {
            sunImageslist.add(s);
            System.out.println(s);
        }
        return sunImageslist;
    }
}
