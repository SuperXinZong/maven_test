package com.dj.test.service.impl;

import com.dj.test.mapper.AreaMapper;
import com.dj.test.pojo.Area;
import com.dj.test.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getArea(Integer parentId) {
        return areaMapper.getAreaByParentId(parentId);
    }

    @Override
    public List<Area> getAll() {
        return areaMapper.getAll();
    }
}
