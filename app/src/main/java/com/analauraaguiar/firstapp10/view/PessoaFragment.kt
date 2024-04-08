package com.analauraaguiar.firstapp10.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.analauraaguiar.firstapp10.R
import com.analauraaguiar.firstapp10.databinding.FragmentCalculoBinding
import com.analauraaguiar.firstapp10.service.model.Pessoa
import com.analauraaguiar.firstapp10.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()
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
            val anoNascimento = binding.edtDataNascimento.editableText.toString()

            if(nome !="" && anoNascimento!="" ){
                binding.tvNome.text ="Nome: ${nome}"

                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()

                binding.tvIdade.text = "Idade: ${idade}"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade

                )

                viewModel.insert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtDataNascimento.editableText.clear()
            }else{
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }

        }
        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)

        }
        }
    }


