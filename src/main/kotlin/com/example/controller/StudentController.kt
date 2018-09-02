package com.example.controller

import com.example.dto.Student
import com.example.mapper.DepartmentMapper
import com.example.mapper.StudentMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("student")
class StudentController @Autowired constructor(
        val studentMapper: StudentMapper,
        val departmentMapper: DepartmentMapper
) {
    @RequestMapping("list")
    fun list(model: Model): String{
        model.addAttribute("students", studentMapper.findAll())
        return "student/list"
    }

    @GetMapping("create")
    fun create(model: Model): String{
        model.addAttribute("student", Student())
        model.addAttribute("departments", departmentMapper.findAll())
        return "student/edit"
    }

    @PostMapping("create")
    fun create(model: Model, student: Student): String{
        studentMapper.insert(student)
        return "redirect:list"
    }

    @GetMapping("edit")
    fun edit(model: Model, @RequestParam("id") id: Int): String{
        model.addAttribute("student", studentMapper.findOne(id))
        model.addAttribute("departments", departmentMapper.findAll())
        return "student/edit"
    }

    @PostMapping("edit")
    fun edit(model: Model, student: Student): String{
        studentMapper.update(student)
        return "redirect:list"
    }

    @RequestMapping("delete")
    fun delete(model: Model, @RequestParam("id") id: Int): String {
        studentMapper.delete(id)
        return "redirect:list"
    }
}