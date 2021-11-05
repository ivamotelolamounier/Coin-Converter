package com.ivamotelo.coinconverter.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ivamotelo.coinconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow
import androidx.room.Query

@Dao
interface ExchangeDao {

    @Query("SELECT * FROM tb_exchange")
    fun findAll(): Flow<List<ExchangeResponseValue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: ExchangeResponseValue)
}