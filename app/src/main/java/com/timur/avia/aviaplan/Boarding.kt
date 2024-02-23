package com.timur.avia.aviaplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.TextView

class Boarding : AppCompatActivity() {
    private lateinit var radioButtonEuropeanPlane: RadioButton
    private lateinit var radioButtonAmericanPlane: RadioButton
    private lateinit var imageViewPlane: ImageView
    private lateinit var textViewSeats: TextView
    private lateinit var infoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding)

        radioButtonEuropeanPlane = findViewById(R.id.radioButtonEuropeanPlane)
        radioButtonAmericanPlane = findViewById(R.id.radioButtonAmericanPlane)
        imageViewPlane = findViewById(R.id.imageViewPlane)
        textViewSeats = findViewById(R.id.textViewSeats)
        infoButton = findViewById(R.id.info)

        infoButton.setOnClickListener {
            val customText = "**Boarding Instructions:**\n" +
                    "\n" +
                    "1. **Check Your Boarding Pass:** Ensure you have your boarding pass ready, either in digital or printed form.\n" +
                    "\n" +
                    "2. **Follow Gate Announcements:** Pay attention to announcements for your flight at the departure gate.\n" +
                    "\n" +
                    "3. **Board by Rows:** Wait for your row to be called before boarding the aircraft.\n" +
                    "\n" +
                    "4. **Have ID Ready:** Have your identification and travel documents ready for inspection.\n" +
                    "\n" +
                    "5. **Stow Carry-On Items:** Place your carry-on items in the overhead bins or under the seat in front of you.\n" +
                    "\n" +
                    "6. **Find Your Seat:** Locate your assigned seat using the seat number on your boarding pass.\n" +
                    "\n" +
                    "7. **Fasten Seatbelt:** Once seated, fasten your seatbelt and prepare for departure.\n" +
                    "\n" +
                    "8. **Listen to Crew Instructions:** Follow any additional instructions from the cabin crew during the boarding process.\n" +
                    "\n" +
                    "9. **Enjoy Your Flight:** Relax and enjoy your journey! If you have any questions, feel free to ask the cabin crew for assistance.\n"
            showPopupWindow(it, customText)
        }

        radioButtonEuropeanPlane.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setEuropeanPlaneInfo()
            }
        }

        radioButtonAmericanPlane.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setAmericanPlaneInfo()
            }
        }
    }

    private fun showPopupWindow(view: View, popupText: String) {
        val popupView: View = LayoutInflater.from(this).inflate(R.layout.popup_layout, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        val textViewPopupContent: TextView = popupView.findViewById(R.id.textViewPopupContent)
        textViewPopupContent.text = popupText

        val buttonClosePopup: Button = popupView.findViewById(R.id.buttonClosePopup)
        buttonClosePopup.setOnClickListener {
            popupWindow.dismiss()
        }
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }

    private fun setEuropeanPlaneInfo() {
        imageViewPlane.setImageResource(R.drawable.plane_es)
        textViewSeats.text = "European Plane Seats"
    }

    private fun setAmericanPlaneInfo() {
        imageViewPlane.setImageResource(R.drawable.plane_usa)
        textViewSeats.text = "American Plane Seats"
    }
}