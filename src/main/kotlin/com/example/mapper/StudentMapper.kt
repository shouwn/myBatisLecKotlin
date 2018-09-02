package com.example.mapper

import com.example.dto.Department
import com.example.dto.Student
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface StudentMapper{
    fun findOne(id: Int): Student
    fun findByStudentNumber(studentNumber: String): Student
    @Select("""
        SELECT s.*, d.departmentName
        FROM student s LEFT JOIN department d ON s.departmentId = d.id
    """)
    fun findAll(): List<Student>
    fun insert(student: Student)
    fun update(student: Student)
    fun delete(id: Int)
}