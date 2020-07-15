package com.dj.test.mapper;

import com.dj.test.pojo.Area;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AreaMapper {
    List<Area> getAreaByParentId(Integer parentId) throws DataAccessException;

    List<Area> getAll() throws DataAccessException;
}
