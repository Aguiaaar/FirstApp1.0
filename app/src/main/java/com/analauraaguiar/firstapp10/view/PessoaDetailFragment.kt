package com.analauraaguiar.firstapp10.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.analauraaguiar.firstapp10.databinding.FragmentPessoaDetailBinding
import com.analauraaguiar.firstapp10.viewmodel.PessoaViewModel


class PessoaDetailFragment : Fragment() {
    //Chamar a viewModel para pegar os dados
    private val viewModel: PessoaViewModel by viewModels()
    //Criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding:FragmentPessoaDetailBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Configurar o binding do xml
        _binding = FragmentPessoaDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    // Chamar a função onVieCreated onde vamos implementar o código
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pegar o id da pessoa que foi enviado pela AllPessoasFragment
        // Setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))

        }
        //Carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.tvNome2.setText(pessoa.nome)
            binding.tvIdade2.setText(pessoa.idade.toString())
            binding.tvFaixaEtaria2.setText(pessoa.faixaEtaria)
            if (pessoa.sexo == "feminino"){
                binding.ivFeminino.visibility = View.VISIBLE
                binding.ivMasculino.visibility = View.GONE
            }else{
                binding.ivMasculino.visibility = View.VISIBLE
                binding.ivFeminino.visibility = View.GONE
            }
    }
    }

}