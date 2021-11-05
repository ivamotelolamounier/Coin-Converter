/**
 * Comportamento padrãos das camadas de um aplicativo MVVM
 * https://www.objective.com.br/wp-content/uploads/2020/01/fluxo-de-comunicacao.png
 * API de conversão de moedas: https://docs.awesomeapi.com.br/api-de-moedas
 *
 */
package com.ivamotelo.coinconverter.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.ivamotelo.coinconverter.data.model.Coin
import com.ivamotelo.coinconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindAdapter()
        bindListeners()
    }

    private fun bindAdapter(){
        // setar o adapter para as moedas disponíveis no "Coin.kt"
        val list = Coin.values()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        // Escolher as moedas para conversão
        binding.tvFrom.setAdapter(adapter)
        binding.tvTo.setAdapter(adapter)

        // Setar para iniciar com moedas padrão
        binding.tvFrom.setText(Coin.BRL.name, false)
        binding.tvTo.setText(Coin.USD.name, false)

    }

    private fun bindListeners(){
        // Função que informa que o texto foi alterado (carregado), habilitando o botão "converter"
        binding.tilValue.editText?.doAfterTextChanged {
            binding.btnConverter.isEnabled = it != null && it.toString().isNotEmpty()
        }

        binding.btnConverter.setOnClickListener {
            Log.e("TAG", "bindListeners:" + binding.tilValue.editText)
        }
    }
}