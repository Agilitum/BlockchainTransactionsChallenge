package com.blockchain.core.network.api.datamodel

data class Txs (
    val result: Int,
    val time: Int,
    val hash: String,
    val fee: Int
)