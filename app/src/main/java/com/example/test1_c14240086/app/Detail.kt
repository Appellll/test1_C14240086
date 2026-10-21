package com.example.test1_c14240086.app

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _telp = findViewById<Button>(R.id.telp)

        _telp.setOnClickListener {
            val _telpIntent = Intent (Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+62 81 2526")
            }
            startActivity(_telpIntent)
        }

        val _kalender = findViewById<Button>(R.id.kalender)

        _kalender.setOnClickListener {
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"))
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val timePickerDialog = TimePickerDialog(
                        this,
                        { _, selectedHour, selectedMinute ->

                            val selectedDateTime = Calendar.getInstance().apply {
                                set(
                                    selectedYear,
                                    selectedMonth,
                                    selectedDay,
                                    selectedHour,
                                    selectedMinute
                                )
                            }
                            val endTime = selectedDateTime.clone() as Calendar
                            endTime.add(Calendar.HOUR_OF_DAY, 1)

                            val eventIntent = Intent(Intent.ACTION_INSERT).apply {
                                data = CalendarContract.Events.CONTENT_URI
                                putExtra(CalendarContract.Events.TITLE, "Meeting")
                                putExtra(CalendarContract.Events.EVENT_LOCATION, "Kantor")
                                putExtra(CalendarContract.Events.DESCRIPTION, "Deskripsi Meeting")
                                putExtra(CalendarContract.Events.ALL_DAY, false)
                                putExtra(
                                    CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                                    selectedDateTime.timeInMillis
                                )
                                putExtra(
                                    CalendarContract.EXTRA_EVENT_END_TIME,
                                    endTime.timeInMillis
                                )
                            }
                            startActivity(eventIntent)

                        }, hour, minute, true
                    )
                    timePickerDialog.show()

                }, year, month, day
            )
            datePickerDialog.show()
        }
    }
}