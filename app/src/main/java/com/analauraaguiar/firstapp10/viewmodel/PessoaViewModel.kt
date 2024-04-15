package com.analauraaguiar.firstapp10.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.analauraaguiar.firstapp10.service.model.Pessoa
import com.analauraaguiar.firstapp10.service.repository.PessoaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PessoaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PessoaRepository(application)

    fun insert(pessoa: Pessoa){
        viewModelScope.launch(Dispatchers.IO) { repository.insertPessoa(pessoa) }

    }
    fun get(id: Int){
        viewModelScope.launch(Dispatchers.IO) { repository.getPessoa(id) }

    }

    fun update(pessoa: Pessoa){
        viewModelScope.launch(Dispatchers.IO) { repository.updatePessoa(pessoa) }

    }
    fun delete(id: Int){
        viewModelScope.launch(Dispatchers.IO) { repository.deletePessoa(id) }
    }

}