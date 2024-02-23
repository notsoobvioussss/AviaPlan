package com.timur.avia.aviaplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import com.timur.avia.aviaplan.databinding.ActivityIdeasBinding

class Ideas : AppCompatActivity() {
    lateinit var binding: ActivityIdeasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.turkey.setOnClickListener {
            val customText = "Explore the allure of Turkey, where ancient wonders meet stunning landscapes. Wander through historic sites like the Hagia Sophia and indulge in the vibrant culture of bustling bazaars. Relax on Mediterranean beaches or marvel at the surreal landscapes of Cappadocia.\n" +
                    "\n" +
                    "Immerse yourself in the rich history of Ephesus and unwind in the thermal waters of Pamukkale. Picture vibrant markets, hear calls to prayer, and savor coastal sunsets.\n" +
                    "\n" +
                    "Book your flight today from 39$ and embark on an adventure to uncover Turkey's captivating beauty."
            showPopupWindow(it, customText)
        }
        binding.china.setOnClickListener {
            val customText = "Discover the enchantment of China, a nation that seamlessly blends ancient marvels with modern wonders. Explore iconic landmarks like the Great Wall and the Forbidden City, steeped in centuries of history. Immerse yourself in the bustling energy of cities like Beijing and Shanghai, where tradition meets innovation.\n" +
                    "\n" +
                    "Marvel at the serene landscapes of Guilin and the picturesque Li River. Witness the ancient Terracotta Army in Xi'an, a testament to China's rich cultural heritage. Delight your senses with diverse culinary offerings, from regional specialties to street food delights.\n" +
                    "\n" +
                    "Picture vibrant markets, hear the melody of traditional music, and witness the allure of ancient temples. Book your flight today from 499$ and embark on a journey to unravel the captivating beauty of China."
            showPopupWindow(it, customText)
        }
        binding.maldives.setOnClickListener {
            val customText = "The Maldives, a tropical paradise in the Indian Ocean, is renowned for its stunning coral islands and crystal-clear turquoise waters. Comprising 26 atolls with over 1,000 coral islands, it's a haven for those seeking idyllic beaches, vibrant marine life, and luxury resorts.\n" +
                    "\n" +
                    "Immerse yourself in the world-class diving and snorkeling sites, where coral reefs teem with colorful marine species. Overwater bungalows offer a unique and romantic escape, surrounded by the serene beauty of the Indian Ocean.\n" +
                    "\n" +
                    "Explore the unique Maldivian culture, influenced by South Asian, Arab, and African traditions. Indulge in fresh seafood, relax in spas overlooking the ocean, and witness breathtaking sunsets.\n" +
                    "\n" +
                    "Book your Maldives getaway today from 500$ and experience the epitome of tropical paradise."
            showPopupWindow(it, customText)
        }
        binding.hungary.setOnClickListener {
            val customText = "Hungary, nestled in the heart of Central Europe, boasts a rich tapestry of history, culture, and natural beauty. With Budapest as its enchanting capital, the country offers a captivating blend of architectural marvels, thermal baths, and a vibrant arts scene.\n" +
                    "\n" +
                    "Explore the banks of the Danube River, where Buda Castle and Fisherman's Bastion provide panoramic views of the city. Immerse yourself in the soothing waters of the famous thermal baths, a testament to Hungary's spa culture.\n" +
                    "\n" +
                    "Delight your taste buds with Hungarian cuisine, known for dishes like goulash and chimney cake. Wander through charming towns with Baroque architecture, such as Eger and Pécs, each telling a unique story of the nation's heritage.\n" +
                    "\n" +
                    "Experience the warmth of Hungarian hospitality, whether sipping on local wines in the Tokaj wine region or joining in the lively festivities of Budapest's ruin bars. Hungary invites you to uncover its diverse landscapes and cultural treasures.\n" +
                    "\n" +
                    "Embark on a journey to Hungary and discover a land where history and modernity harmoniously coexist. Book your flight from 50$."
            showPopupWindow(it, customText)
        }
        binding.mexico.setOnClickListener {
            val customText = "Mexico, a vibrant and diverse country in North America, captivates with its rich cultural heritage, breathtaking landscapes, and lively traditions. From the ancient wonders of the Aztec and Maya civilizations to the modern energy of bustling cities, Mexico offers a kaleidoscope of experiences.\n" +
                    "\n" +
                    "Explore the historic charms of Mexico City, where the Zócalo and Frida Kahlo's Casa Azul beckon with stories of the past. Journey to the archaeological marvels of Chichen Itza and Palenque, where ancient pyramids stand testament to Mexico's pre-Columbian civilizations.\n" +
                    "\n" +
                    "Indulge in the flavors of Mexican cuisine, from street tacos to mole poblano, and sip on tequila in the agave fields of Jalisco. Relax on the pristine beaches of Cancun and Playa del Carmen or wander through the colonial streets of Oaxaca and Guanajuato.\n" +
                    "\n" +
                    "Immerse yourself in the vibrant celebrations of Dia de los Muertos, witness the colorful art of Mexican muralists, and feel the rhythm of traditional mariachi music. Mexico invites you to a world where history, nature, and culture come together in a lively fiesta.\n" +
                    "\n" +
                    "Book your journey to Mexico today from 500$ and embark on an adventure that promises to awaken your senses and leave you enchanted with its diversity and warmth."
            showPopupWindow(it, customText)
        }
        binding.india.setOnClickListener {
            val customText = "India, a land of contrasts and diversity, enchants with its rich tapestry of culture, history, and breathtaking landscapes. From the snow-capped Himalayas in the north to the sun-kissed beaches of the south, India offers a sensory journey like no other.\n" +
                    "\n" +
                    "Discover the architectural wonders of ancient civilizations at sites like the Taj Mahal, Jaipur's Hawa Mahal, and the temples of Varanasi. Immerse yourself in the spiritual aura of the Ganges River and witness the vibrant chaos of bustling markets and lively festivals.\n" +
                    "\n" +
                    "Savor the kaleidoscope of flavors in Indian cuisine, from aromatic curries to street food delights. Traverse through the vibrant streets of Delhi, experience the royal heritage of Rajasthan, and unwind in the serene backwaters of Kerala.\n" +
                    "\n" +
                    "Experience the warmth of Indian hospitality, where traditions are passed down through generations. Marvel at the intricate dance forms, colorful festivals, and the intricate artistry of traditional handcrafts.\n" +
                    "\n" +
                    "India invites you to explore its captivating diversity, where ancient wisdom meets modern aspirations. Book your journey to India today from 230$ and embark on an odyssey of discovery through a land that celebrates unity in diversity."
            showPopupWindow(it, customText)
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

}