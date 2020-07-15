package com.dj.test.service;

import com.dj.test.pojo.Area;

import java.util.List;

public interface AreaService {

    List<Area> getArea(Integer parentId);

    List<Area> getAll();
}
