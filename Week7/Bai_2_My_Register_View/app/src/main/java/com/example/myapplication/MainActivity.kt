package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import androidx.core.view.isGone


class MainActivity: ComponentActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var rbGender: RadioGroup
    private lateinit var etBirthday: EditText
    private lateinit var btnSelect: Button
    private lateinit var calendarView: CalendarView
    private lateinit var etAddress: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbTerms: CheckBox
    private lateinit var btnRegister: Button

    private var defaultEditTextBackground: Drawable? = null
    private var isCalendarViewVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bai2)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        rbGender = findViewById(R.id.rgGender)
        etBirthday = findViewById(R.id.etBirthday)
        btnSelect = findViewById(R.id.btnSelect)
        calendarView = findViewById(R.id.CalenderView)
        etAddress = findViewById(R.id.etAddress)
        etEmail = findViewById(R.id.etEmail)
        cbTerms = findViewById(R.id.cb)
        btnRegister = findViewById(R.id.btnRegister)

        calendarView.visibility = View.GONE

        defaultEditTextBackground = etFirstName.background

        setDateSelection()

        btnRegister.setOnClickListener {
            validateInputs()
        }
    }

    private fun setDateSelection() {

        btnSelect.setOnClickListener {
            if (calendarView.isGone) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)

            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            etBirthday.setText(dateFormat.format(selectedDate.time))

            calendarView.visibility = View.GONE
        }


    }

    private fun validateInputs() {
        var valid = true

        restoreDefaultBackground(etFirstName)
        restoreDefaultBackground(etLastName)
        restoreDefaultBackground(etBirthday)
        restoreDefaultBackground(etAddress)
        restoreDefaultBackground(etEmail)

        if (etFirstName.text.isNullOrBlank()) {
            markAsInvalid(etFirstName)
            valid = false
        }
        if (etLastName.text.isNullOrBlank()) {
            markAsInvalid(etLastName)
            valid = false
        }
        if (etBirthday.text.isNullOrBlank()) {
            markAsInvalid(etBirthday)
            valid = false
        }
        if (etAddress.text.isNullOrBlank()) {
            markAsInvalid(etAddress)
            valid = false
        }
        if (etEmail.text.isNullOrBlank()) {
            markAsInvalid(etEmail)
            valid = false
        }

        if (!cbTerms.isChecked) {
            cbTerms.setTextColor(Color.RED)
            valid = false
        } else {
            cbTerms.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        }

        if (valid) {
            val gender = if (rbGender.checkedRadioButtonId == R.id.rbtnMale) "Male" else "Female"

            val message = "Registration Successful!\n" +
                    "Name: ${etFirstName.text} ${etLastName.text}\n" +
                    "Gender: $gender\n" +
                    "Birthday: ${etBirthday.text}\n" +
                    "Address: ${etAddress.text}\n" +
                    "Email: ${etEmail.text}"

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun markAsInvalid(editText: EditText) {
        val redColor = ContextCompat.getColor(this, android.R.color.holo_red_light)
        editText.background = redColor.toDrawable()
    }

    private fun restoreDefaultBackground(editText: EditText) {
        editText.background = defaultEditTextBackground
        if (editText.id != R.id.cb) {
            cbTerms.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        }
    }

}