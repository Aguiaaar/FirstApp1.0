package com.analauraaguiar.firstapp10.service.repository

import android.content.Context
import com.analauraaguiar.firstapp10.service.model.Pessoa
import com.analauraaguiar.firstapp10.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private val firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun insertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa)
    }
    suspend fun getPessoa(id: Int){
        firstAppDb.getPessoa(id)
    }
    suspend fun loadPessoas(){
        firstAppDb.getAll()
    }
    suspend fun updatePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }

    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }
}