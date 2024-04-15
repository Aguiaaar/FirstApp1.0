package com.analauraaguiar.firstapp10.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.analauraaguiar.firstapp10.R
import com.analauraaguiar.firstapp10.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCadastroPessoa.setOnClickListener {
            findNavController().navigate(R.id.allPessoasFragment)

        }
        binding.btnVerifica.setOnClickListener {
            findNavController().navigate(R.id.verificaFragment)
        }
    }

    }
