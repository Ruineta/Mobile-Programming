package com.example.dssv.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {

    private val _students = MutableLiveData<MutableList<Student>>(
        mutableListOf(
            Student("20252001", "Nguyễn Văn A", "0966283841", "Phú Yên"),
            Student("20252002", "Trần Thị B", "0983524682", "Khánh Hoà"),
            Student("20252003", "Lê Văn C", "0399597738", "Cần Thơ"),
            Student("20252004", "Phạm Thị D", "0915423344", "Hải Phòng")
        )
    )
    val students: LiveData<MutableList<Student>> get() = _students

    fun getStudentAt(index: Int): Student? {
        return _students.value?.getOrNull(index)
    }

    fun addStudent(student: Student) {
        val list = _students.value ?: mutableListOf()
        list.add(student)
        _students.value = list
    }

    fun updateStudent(index: Int, student: Student) {
        val list = _students.value ?: return
        if (index in list.indices) {
            list[index] = student
            _students.value = list
        }
    }
}
