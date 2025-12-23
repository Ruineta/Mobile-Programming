package com.example.dssv.repository

import com.example.dssv.model.Student

object StudentRepository {
    val students = mutableListOf<Student>(
        Student("20252001", "Nguyễn Văn A", "0966283841", "Phú Yên"),
        Student("20252002", "Trần Thị B", "0983524682", "Khánh Hoà"),
        Student("20252003", "Lê Văn C", "0399597738", "Cần Thơ"),
        Student("20252004", "Phạm Thị D", "0915423344", "Hải Phòng")
    )
}