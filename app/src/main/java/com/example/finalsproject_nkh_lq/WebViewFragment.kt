package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

var Any.webViewClient: WebViewClient
    get() {}
    set(value) {}

class WebViewFragment<WebViewFragmentArgs> : Fragment() {

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
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("https://example.com")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}