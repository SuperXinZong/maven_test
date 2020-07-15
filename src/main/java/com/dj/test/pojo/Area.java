package com.dj.test.pojo;

import lombok.Data;

@Data
public class Area {

    private Integer id;

    private String areaName;

    private Integer areaParentId;

    /**
     * 是否是父节点
     */
    private Boolean isParent = false;

    /**
     * 是否勾选
     */
    private Boolean checked = false;
}
