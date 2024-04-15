package com.analauraaguiar.firstapp10.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.analauraaguiar.firstapp10.databinding.FragmentVerificaBinding

class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding:FragmentVerificaBinding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVerificaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            val email = binding.edtEmail.editableText.toString()

            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.setTextColor(Color.BLACK)
                binding.tvEmail.text = "Email: ${email}"
            } else {
                binding.tvEmail.setTextColor(Color.RED)
                binding.tvEmail.text = "Email inválido"
            }

            val telefone = binding.edtHintTelefone.editableText.toString()
            val tamanhoTelefone = telefone.length

            if (tamanhoTelefone == 11) {
                binding.tvTelefone.setTextColor(Color.BLACK)
                binding.tvTelefone.text = "Telefone: ${telefone}"

            } else {
                binding.tvTelefone.setTextColor(Color.RED)
                binding.tvTelefone.text = "Telefone inválido"
            }
        }


    }

}