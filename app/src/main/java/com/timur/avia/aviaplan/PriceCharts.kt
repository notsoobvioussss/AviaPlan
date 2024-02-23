package com.timur.avia.aviaplan

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class PriceCharts : AppCompatActivity() {

    private lateinit var cityFromEditText: EditText
    private lateinit var cityToEditText: EditText
    private lateinit var dateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_charts)

        cityFromEditText = findViewById(R.id.editTextCityFrom)
        cityToEditText = findViewById(R.id.editTextCityTo)
        dateEditText = findViewById(R.id.editTextDate)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCountries)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val countries = listOf(
            Country("Dubai, from 60$", R.drawable.ic_country1),
            Country("Geneve, from 40$", R.drawable.ic_country2),
            Country("Milan, from 99$", R.drawable.ic_country3),
            Country("Astana, from 70$", R.drawable.ic_country4),
            Country("Tashkent, from 90$", R.drawable.ic_country5),
            Country("New York, from 200$", R.drawable.ic_country6),
            Country("Miami, from 210$", R.drawable.ic_country7),
            Country("Erevan, from 100$", R.drawable.ic_country8),
            Country("Prague, from 80$", R.drawable.ic_country9),
            Country("Paris, from 150$", R.drawable.ic_country10),
        )

        val adapter = CountryAdapter(countries)
        recyclerView.adapter = adapter

        val recommendButton: Button = findViewById(R.id.buttonRecommend)
        recommendButton.setOnClickListener {
            handleRecommendation()
        }

        dateEditText.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                hideKeyboard()
                showDatePicker()
            }
            view.performClick()
            true
        }
    }

    private fun handleRecommendation() {
        val cityFrom = cityFromEditText.text.toString()
        val cityTo = cityToEditText.text.toString()

        if (!isValidCityName(cityFrom) || !isValidCityName(cityTo)) {
            Toast.makeText(this, "Incorrect cities name", Toast.LENGTH_SHORT).show()
            return
        }

        val priceTextView: TextView = findViewById(R.id.textViewPrice)
        val classPriceRange = if (isEconomyClassSelected()) {
            10..20
        } else {
            70..100
        }

        val price =
            "Normal Price for this flight from $${(classPriceRange.random())} to $${(classPriceRange.random() + 25)}"
        priceTextView.text = price
    }

    private fun isValidCityName(cityName: String): Boolean {
        val regex = Regex("^[A-Z][a-z]*\$")
        return cityName.matches(regex)
    }

    private fun isEconomyClassSelected(): Boolean {
        val economyRadioButton: RadioButton = findViewById(R.id.radioButtonEconomy)
        return economyRadioButton.isChecked
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                dateEditText.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
            },
            year, month, day
        )
        datePickerDialog.show()
    }
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private data class Country(val name: String, val imageResId: Int)

    private class CountryAdapter(private val countries: List<Country>) :
        RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

        private val infiniteCountries: MutableList<Country> = mutableListOf()

        init {
            for (i in 0 until INFINITE_SCROLL_COUNT) {
                infiniteCountries.addAll(countries)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
            return CountryViewHolder(view)
        }

        override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
            val country = infiniteCountries[position % countries.size]
            holder.bind(country)
        }

        override fun getItemCount(): Int {
            return infiniteCountries.size
        }

        class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(country: Country) {
                val countryImageView: ImageView = itemView.findViewById(R.id.imageViewCountry)
                val countryNameTextView: TextView = itemView.findViewById(R.id.textViewCountryName)

                countryImageView.setImageResource(country.imageResId)
                countryNameTextView.text = country.name
            }
        }

        fun addMoreCountries() {
            infiniteCountries.addAll(countries)
            notifyDataSetChanged()
        }
    }

    companion object {
        private const val INFINITE_SCROLL_COUNT = 5
    }
}
