package com.dj.test.web;

import com.dj.test.base.ResultModel;
import com.dj.test.pojo.Area;
import com.dj.test.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/getArea/{parentId}")
    public ResultModel getArea(@PathVariable Integer parentId) {
        List<Area> areaList = areaService.getArea(parentId);
        return new ResultModel().success(areaList);
    }

    @RequestMapping("/getAll")
    public ResultModel getAll() {


                List<Area> allList = areaService.getAll();
        for (int i = 0; i < allList.size(); i++) {
            if (i % 2 == 0) {
                allList.get(i).setChecked(true);
            }
        }
        return new ResultModel().success(allList);
    }

    @RequestMapping("/getAsync")
    public List<Area> getAsync(Integer id){
        if (id == null) {
            id = 0;
        }
        // 异步数据
        List<Area> areaList = areaService.getArea(id);
        // 判断是否有子节点
//        for (Area area: areaList) {// TODO 循环调用数据库
//            List<Area> childList = areaService.getArea(area.getId());
//            if (childList != null && !childList.isEmpty()) {
//                area.setIsParent(true);
//            }
//        }
        // 全部数据
        // TODO 无法避免加载全部数据
        List<Area> allList = areaService.getAll();
        for (Area area: areaList) {
            for (Area all: allList) {
                // id和pid比较 相等说明有子节点
                if (area.getId().equals(all.getAreaParentId())) {
                    area.setIsParent(true);
                    break;
                }
            }
        }
        return areaList;
    }

}
