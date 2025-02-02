package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs

private val <WebViewFragmentArgs> WebViewFragmentArgs.url: String
    get() {
        TODO("Not yet implemented")
    }

class WebViewFragment<WebViewFragmentArgs>() : Fragment(), Parcelable {

    private val args: WebViewFragmentArgs by navArgs()

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)
        val webView = view.findViewById<WebView>(R.id.webView)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(args.url)

        return view
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FragmentWebViewBinding<Any?>> {
        override fun createFromParcel(parcel: Parcel): FragmentWebViewBinding<Any?> {
            return FragmentWebViewBinding(parcel)
        }

        override fun newArray(size: Int): Array<FragmentWebViewBinding<Any?>?> {
            return arrayOfNulls(size)
        }
    }
}
