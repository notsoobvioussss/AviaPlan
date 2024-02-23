package com.timur.avia.aviaplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CheckIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val textViewInstructions: TextView = findViewById(R.id.textViewInstructions)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            updateInstructions(radioButton.text.toString())
        }
    }

    private fun updateInstructions(selectedOption: String) {
        val instructions: String = when (selectedOption) {
            "International flight" -> "International Flight Check-In Instructions:\n" +
                    "\n" +
                    "1. **Arrival Time:** Arrive at the airport well in advance of your international flight. We recommend reaching the airport at least 3 hours before the scheduled departure time due to additional security checks and procedures.\n" +
                    "\n" +
                    "2. **Check-In Options:**\n" +
                    "   - Online Check-In: Take advantage of online check-in through our official website or mobile app. Check-in opens 24 hours before the international flight departure.\n" +
                    "   - Airport Kiosk: Self-service kiosks are available at the airport for a quick and seamless check-in process.\n" +
                    "   - Check-In Counter: Visit the airline check-in counter for assistance and to drop off any checked baggage.\n" +
                    "\n" +
                    "3. **Documents Required:**\n" +
                    "   - Passport and Visa: Ensure your passport is valid for at least six months beyond your intended return date. Verify that you have the necessary visas for your destination.\n" +
                    "   - Boarding Pass: Have your electronic or printed boarding pass ready for security checks.\n" +
                    "\n" +
                    "4. **Security Screening:** Undergo thorough security screening. Follow all instructions from security personnel and be prepared for additional screening processes.\n" +
                    "\n" +
                    "5. **Customs Declaration:** Complete any required customs declaration forms. Be aware of the items allowed and restricted in your destination country.\n" +
                    "\n" +
                    "6. **Boarding Gate:** Proceed to the designated international boarding gate mentioned on your boarding pass. Boarding typically begins approximately 45 minutes before the international flight.\n" +
                    "\n" +
                    "7. **Seat Assignment:** If you haven't selected a seat during check-in, check the gate monitor for your seat assignment.\n" +
                    "\n" +
                    "8. **Immigration Clearance:** Pass through immigration control. Present your passport, visa, and any required documentation.\n" +
                    "\n" +
                    "9. **Boarding:** When your row is called, board the aircraft in an orderly fashion. Follow the cabin crew's instructions for a smooth boarding process.\n" +
                    "\n" +
                    "10. **In-Flight Experience:** Enjoy your international flight! Follow any announcements from the flight crew and adhere to safety guidelines.\n" +
                    "\n" +
                    "Safe and pleasant travels!\n"
            "Domestic flight" -> "Domestic Flight Check-In Instructions:\n" +
                    "\n" +
                    "1. **Arrival Time:** Arrive at the airport well in advance of your domestic flight. We recommend reaching the airport at least 2 hours before the scheduled departure time.\n" +
                    "\n" +
                    "2. **Check-In Options:**\n" +
                    "   - Online Check-In: Utilize the convenience of online check-in through our official website or mobile app. Check-in opens 24 hours before the flight departure.\n" +
                    "   - Airport Kiosk: Self-service kiosks are available at the airport for a quick and seamless check-in process.\n" +
                    "   - Check-In Counter: Visit the airline check-in counter for assistance and to drop off any checked baggage.\n" +
                    "\n" +
                    "3. **Documents Required:**\n" +
                    "   - Valid Photo ID: Ensure you have a government-issued photo identification, such as a driver's license or passport.\n" +
                    "   - Boarding Pass: Have your electronic or printed boarding pass ready for security checks.\n" +
                    "\n" +
                    "4. **Security Screening:** Pass through the security screening area. Be prepared to remove any metal items and follow the instructions of security personnel.\n" +
                    "\n" +
                    "5. **Boarding Gate:** Proceed to the designated boarding gate mentioned on your boarding pass. Boarding typically begins approximately 30 minutes before the flight.\n" +
                    "\n" +
                    "6. **Seat Assignment:** If you haven't selected a seat during check-in, check the gate monitor for your seat assignment.\n" +
                    "\n" +
                    "7. **Boarding:** When your row is called, board the aircraft in an orderly fashion. Follow the cabin crew's instructions for a smooth boarding process.\n" +
                    "\n" +
                    "8. **In-Flight Experience:** Enjoy your flight! Follow any announcements from the flight crew and adhere to safety guidelines.\n" +
                    "\n" +
                    "Safe travels!\n"
            else -> ""
        }

        val textViewInstructions: TextView = findViewById(R.id.textViewInstructions)
        textViewInstructions.text = instructions
    }
}