@file:Suppress("UNREACHABLE_CODE")

package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs


private var Any.webViewClient: Unit
    get() = Unit
    set(value) {}

class WebViewFragment<WebViewFragmentArgs>(parcel: Parcel) : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!
    private val args: WebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = args.url
        binding.webView.loadUrl("https://example.com").also { binding.webView.webViewClient = it }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun Any.loadUrl(s: String) {
            TODO("Not yet implemented")
}
