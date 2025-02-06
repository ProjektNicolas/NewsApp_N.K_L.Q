package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.finalsproject_nkh_lq.databinding.FragmentWebViewBinding // Ensure correct import

class FragmentWebViewBinding : Fragment() {

    val root: View? = null
    val webView: Any = TODO()
    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://example.com") // Replace with actual URL
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks
    }

    companion object {
        fun inflate(
            inflater: LayoutInflater,
            container: ViewGroup?,
            b: Boolean
        ): com.example.finalsproject_nkh_lq.FragmentWebViewBinding? {
            TODO("Not yet implemented")
        }
    }
}
