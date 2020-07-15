package com.dj.test.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private List<Integer> userIds;

    private Student student;

}
