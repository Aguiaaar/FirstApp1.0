package com.analauraaguiar.firstapp10.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.analauraaguiar.firstapp10.databinding.FragmentPessoaBinding
import com.analauraaguiar.firstapp10.service.model.Pessoa
import com.analauraaguiar.firstapp10.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()
    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Carregar a pessoa caso tenha selecionado
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))
        }
        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            val anoNascimento = binding.edtDataNascimento.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            val idade = anoAtual - anoNascimento.toInt()
            var faixaEtaria = ""

            if (idade <= 12) {
                faixaEtaria = "Infantil"
            } else if (idade <= 17) {
                faixaEtaria = "Adolescente"
            } else if (idade <= 64) {
                faixaEtaria = "Adulto"
            } else {
                faixaEtaria = "Idoso"
            }

            var sexo = ""
            if (nome != "" && anoNascimento != "" && binding.rbFeminino.isChecked || binding.rbMasculino.isChecked == true) {

                if (binding.rbFeminino.isChecked) {
                    sexo = "feminino"
                } else {
                    sexo = "masculino"
                }

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaEtaria = faixaEtaria

                )
                viewModel.pessoa.value?.let {
                    pessoa.id = it.id
                    viewModel.update(pessoa)
                }?:run {
                    viewModel.insert(pessoa)
                }



                binding.edtNome.editableText.clear()
                binding.edtDataNascimento.editableText.clear()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }

        }
        binding.btnDeletar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Você realmente deseja excluir?")
                .setPositiveButton("Sim"){ _,_->
                    viewModel.delete(viewModel.pessoa.value?.id?:0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("Não"){_,_-> }
                .show()

        }
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.edtNome.setText(pessoa.nome)
            binding.edtDataNascimento.setText((LocalDateTime.now().year - pessoa.idade).toString())
            if(pessoa.sexo == "masculino"){
                binding.rbMasculino.isChecked = true
            }else{
                binding.rbFeminino.isChecked = true
            }
            binding.btnDeletar.visibility = View.VISIBLE
        }
        }
    }


