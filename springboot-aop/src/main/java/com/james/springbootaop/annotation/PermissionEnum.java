package com.james.springbootaop.annotation;

/**
 * 枚举定义权限
 *
 * @Author yujie.pan
 * @Date 2019/11/13 10:45
 **/
public enum PermissionEnum {

    DEFAULT("0"),

    ADMIN("1"),

    ADMINISTRATOR("2");

    private String id;

    private PermissionEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
