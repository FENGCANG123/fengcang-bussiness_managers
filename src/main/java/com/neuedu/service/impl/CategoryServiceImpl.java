package com.neuedu.service.impl;

import com.neuedu.dao.CategoryMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int addCategory(Category category) throws MyException {
        return 0;
    }

    @Override
    public int deleteCategory(int categoryId) throws MyException {
        return 0;
    }

    @Override
    public int updateCategory(Category record) throws MyException {
        if(record.getName()==null||record.getName().equals(""))
        {
            throw new MyException("类别名不能为空","");
        }
        if(record.getSortOrder()==null||record.getSortOrder().equals(""))
        {
            throw new MyException("类别SortOrder不能为空","");
        }
        Category category=categoryMapper.selectByPrimaryKey(record.getId());
        int result=categoryMapper.exsitsCategoryname(record.getName());
        if (result>0&&!category.getName().equals(record.getName()))
        {
            throw new MyException("类名已存在","");
        }
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<Category> findAll() throws MyException {

        return categoryMapper.selectAll();


    }

    @Override
    public Category findCategoryById(int categoryId) {

        return  categoryMapper.selectByPrimaryKey(categoryId);

    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        if(record.getName()==null||record.getName().equals(""))
        {
            throw new MyException("类别名不能为空","");
        }
        if(record.getSortOrder()==null||record.getSortOrder().equals(""))
        {
            throw new MyException("类别SortOrder不能为空","");
        }
        int result=categoryMapper.exsitsCategoryname(record.getName());
        if (result>0)
        {
            throw new MyException("类名已存在","");
        }
        return categoryMapper.insert(record);
    }
}
