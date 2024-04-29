package com.analauraaguiar.firstapp10.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.analauraaguiar.firstapp10.databinding.ListItemPessoaBinding
import com.analauraaguiar.firstapp10.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit):
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){
        // Criar uma lista vazia de pessoas
        private var pessoaList: List<Pessoa> = arrayListOf()
    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root) {

            // Carrega as informações da pessoa na lista
        fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit){
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString() + " anos"
            binding.tvFaixaEtaria.text = pessoa.faixaEtaria


            //Método 1 para esconder ou mostrar uma imagem
            if(pessoa.sexo == "feminino"){
                binding.ivFeminino.visibility = View.VISIBLE
                binding.ivMasculino.visibility = View.GONE
            }else{
                binding.ivMasculino.visibility = View.VISIBLE
                binding.ivFeminino.visibility = View.GONE
 }
            //Método 2 para esconder ou mostrar uma imagem
//            if (pessoa.sexo == "feminino"){
//                binding.ivFeminino.setImageResource(R.drawable.simbolo_feminino_svg)
//            }else{
//                binding.ivMasculino.setImageResource(R.drawable.sexo_masculino_svg)
//            }

            //Configura o clique de algum item da lista
            binding.root.setOnClickListener{
                clickListListener(pessoa)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        //Configura o binding da lista
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }
    // Carrega a lista de pessoas para serem exibidas
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}