package com.example.mapper

import com.example.dto.Department
import com.example.dto.Student
import org.apache.ibatis.annotations.*

@Mapper
interface StudentMapper{
    @Select("""
        SELECT * FROM student WHERE id = #{id}
    """)
    fun findOne(id: Int): Student

    @Select("""
        SELECT * FROM student
        WHERE studentNumber = #{studentNumber}
    """)
    fun findByStudentNumber(studentNumber: String): Student

    @Select("""
        SELECT s.*, d.departmentName
        FROM student s LEFT JOIN department d ON s.departmentId = d.id
    """)
    fun findAll(): List<Student>

    @Insert(value = """
        INSERT student (studentNumber, name, departmentId, year)
        VALUES (#{studentNumber}, #{name}, #{departmentId}, #{year})
    """)
    fun insert(student: Student)

    @Update("""
        UPDATE student SET
        studentNumber = #{studentNumber},
        name = #{name},
        departmentId = #{departmentId},
        year = #{year}
        WHERE id = #{id}
    """)
    fun update(student: Student)

    @Delete("""
        DELETE FROM student WHERE id = #{id}
    """)
    fun delete(id: Int)
}