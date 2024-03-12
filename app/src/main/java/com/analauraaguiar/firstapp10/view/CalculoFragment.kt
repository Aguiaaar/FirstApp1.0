package com.analauraaguiar.firstapp10.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.analauraaguiar.firstapp10.R
import com.analauraaguiar.firstapp10.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {
    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener{
            val nome = binding.edtNome.editableText.toString()

            binding.tvNome.text ="Nome: ${nome}"

            val anoNascimento = binding.edtDataNascimento.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            val idade = anoAtual - anoNascimento.toInt()
            binding.tvIdade.text = "Idade: ${idade}"

        }
        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        }
    }


