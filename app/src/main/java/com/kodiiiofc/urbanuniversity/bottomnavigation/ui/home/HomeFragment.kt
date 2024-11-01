package com.kodiiiofc.urbanuniversity.bottomnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kodiiiofc.urbanuniversity.bottomnavigation.databinding.FragmentHomeBinding
import com.kodiiiofc.urbanuniversity.bottomnavigation.ui.chat.ChatViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val textView = binding.homeTv
        chatViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}