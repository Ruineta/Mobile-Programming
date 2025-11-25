package com.example.email

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.email.adapter.EmailAdapter
import com.example.email.model.Email
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var rvEmails: RecyclerView
    private lateinit var fabCompose: FloatingActionButton
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvEmails = findViewById(R.id.rvEmails)
        fabCompose = findViewById(R.id.fabCompose)

        val list = createDummyEmails()
        rvEmails.layoutManager = LinearLayoutManager(this)
        rvEmails.adapter = EmailAdapter(list)

        fabCompose.setOnClickListener {
            Toast.makeText(this, "Compose new mail", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createDummyEmails(): List<Email> {
        return listOf(
            Email("MACROHARD",  "EARN THIS FOR FREE", "Are you looking for a good offer?", "9:00 AM"),
            Email("Sarah Johnson", "Your weekly report is ready", "Click to view your dashboard summary.", "8:15 AM"),
            Email("Mark Thompson", "Update your account details", "A reminder to verify your information.", "9:42 AM"),
            Email("Lena Patel", "Exclusive offer just for you", "Save big with our limited-time discount.", "10:05 AM", true),
            Email("James Lee", "Your order has shipped!", "Track your package in real time.", "1:18 PM"),
            Email("Olivia Martinez", "Meeting rescheduled", "We’ve updated the time—please review.", "2:47 PM"),
            Email("David Chen", "Security alert on your account", "We noticed a new login attempt.", "3:33 PM"),
            Email("Emily Rogers", "Invitation to our webinar", "Join us to learn new strategies.", "4:56 PM"),
            Email("Tomás Rivera", "Your subscription is expiring", "Renew now to avoid interruption.", "6:21 PM", true)
        )
    }
}
