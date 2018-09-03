package com.example.mapper

import com.example.dto.Department
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface DepartmentMapper {
    @Select("""
        SELECT * FROM department
    """)
    fun findAll(): List<Department>
}