package com.example.playstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playstore.adapter.RowAdapter
import com.example.playstore.model.AppItem
import com.example.playstore.model.AppRow
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var rvRows: RecyclerView
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvRows = findViewById(R.id.rvRows)
        rvRows.layoutManager = LinearLayoutManager(this)

        rvRows.adapter = RowAdapter(createDummyData())
    }

    private fun createDummyData(): List<AppRow> {
        val suggestedApps = listOf(
            AppItem(
                name = "Truy Kích",
                category = "Action · FPS",
                rating = 4.8f,
                sizeMb = 624
            ),
            AppItem(
                name = "MU: Đại Thiên Sứ H5",
                category = "Role Playing",
                rating = 4.8f,
                sizeMb = 339
            ),
            AppItem(
                name = "Uma Musume Pretty Derby",
                category = "Strategy · Gacha · Role Playing",
                rating = 4.9f,
                sizeMb = 231
            )
        )

        val recommendedApps = listOf(
            AppItem("Taylor Swift", "Music & Audio", 4.6f, 120),
            AppItem("GitHub", "Productivity", 4.7f, 80),
            AppItem("Netflick", "Entertainment", 4.5f, 95),
            AppItem("Another ", "Tools", 4.2f, 50)
        )

        return listOf(
            AppRow(
                title = "Suggested apps",
                apps = suggestedApps,
                layoutType = AppRow.LayoutType.VERTICAL_LIST
            ),
            AppRow(
                title = "Recommended apps",
                apps = recommendedApps,
                layoutType = AppRow.LayoutType.HORIZONTAL_STRIP
            )
        )
    }
}
