package com.example.mapper

import com.example.dto.Department
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DepartmentMapper {
    fun findAll(): List<Department>
}