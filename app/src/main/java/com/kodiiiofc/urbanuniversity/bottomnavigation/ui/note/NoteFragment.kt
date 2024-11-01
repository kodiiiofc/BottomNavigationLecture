package com.kodiiiofc.urbanuniversity.bottomnavigation.ui.note

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kodiiiofc.urbanuniversity.bottomnavigation.R
import com.kodiiiofc.urbanuniversity.bottomnavigation.databinding.FragmentHomeBinding
import com.kodiiiofc.urbanuniversity.bottomnavigation.databinding.FragmentNoteBinding
import com.kodiiiofc.urbanuniversity.bottomnavigation.ui.chat.ChatViewModel

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val textView = binding.noteTv
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