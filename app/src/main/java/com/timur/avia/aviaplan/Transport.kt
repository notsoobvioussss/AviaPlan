package com.timur.avia.aviaplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timur.avia.aviaplan.databinding.ActivityTransportBinding

class Transport : AppCompatActivity() {
    lateinit var binding: ActivityTransportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewDescription.setText("To make your journey to the airport smooth and hassle-free, consider the following transportation options:\n" +
                "\n" +
                "            1. **Private Car or Taxi:**\n" +
                "               - The most convenient option, especially if you have heavy luggage.\n" +
                "               - Ensure you book a reliable service in advance.\n" +
                "\n" +
                "            2. **Airport Shuttle Services:**\n" +
                "               - Some airports offer shuttle services from key locations in the city.\n" +
                "               - Check the schedule and availability.\n" +
                "\n" +
                "            3. **Public Transportation:**\n" +
                "               - Buses and trains are cost-effective options.\n" +
                "               - Confirm the schedules and routes in advance.\n" +
                "\n" +
                "            4. **Ride-Sharing Apps:**\n" +
                "               - Services like Uber or Lyft can be convenient and provide real-time tracking.\n" +
                "\n" +
                "            5. **Personal Vehicles:**\n" +
                "               - If you're driving, plan your route, and consider parking options.\n" +
                "               - Check for any road closures or traffic alerts.\n" +
                "\n" +
                "            Remember to factor in travel time, potential delays, and the airport's recommended check-in time. Safe travels!")

    }
}