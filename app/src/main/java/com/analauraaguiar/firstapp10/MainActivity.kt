package com.analauraaguiar.firstapp10

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.analauraaguiar.firstapp10.databinding.ActivityMainBinding
import com.analauraaguiar.firstapp10.databinding.TelaLinearBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEnviar.setOnClickListener{
//            val nome = binding.edtNome.editableText.toString()
//
//            binding.tvNome.text ="Nome: ${nome}"
//
//            val anoNascimento = binding.edtDataNascimento.editableText.toString()
//            val anoAtual = LocalDateTime.now().year
//            val idade = anoAtual - anoNascimento.toInt()
//            binding.tvIdade.text = "Idade: ${idade}"
//
//        }
        binding.btnEnviar.setOnClickListener {
            val email = binding.edtEmail.editableText.toString()


            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.setTextColor(Color.BLACK)
                binding.tvEmail.text = "Email: ${email}"
            } else {
                binding.tvEmail.setTextColor(Color.RED)
                binding.tvEmail.text = "Email inválido"
            }

            val telefone = binding.edtTelefone.editableText.toString()
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