package com.tes1.evaluate.domain;

public class Department {
    private Integer id;
    private String departmentName;
    private Integer DeptPid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getDeptPid() {
        return DeptPid;
    }

    public void setDeptPid(Integer deptPid) {
        DeptPid = deptPid;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();


    }
}