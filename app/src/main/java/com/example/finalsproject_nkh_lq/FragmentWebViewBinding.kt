package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

private var Any.javaScriptEnabled: Boolean
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}
private val Any.settings: Any
    get() {
        TODO("Not yet implemented")
    }
private val Any.webView: Any
    get() {
        TODO("Not yet implemented")
    }

class WebViewFragment : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://example.com") // Replace with dynamic URL
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks
    }
}

private fun Any.loadUrl(s: String) {
    TODO("Not yet implemented")
}

abstract class FragmentWebViewBinding {
    abstract val root: View?

    companion object {
        fun inflate(
            inflater: LayoutInflater,
            container: ViewGroup?,
            b: Boolean
        ): FragmentWebViewBinding? {
            TODO("Not yet implemented")
        }
    }

}
