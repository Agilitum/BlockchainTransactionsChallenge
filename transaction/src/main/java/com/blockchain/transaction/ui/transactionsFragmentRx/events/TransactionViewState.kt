package com.blockchain.transaction.ui.transactionsFragmentRx.events

import com.blockchain.core.network.api.datamodel.Txs

data class TransactionViewState (
    val transactions: List<Txs> = listOf(),
    val transactionsError: ErrorViewState = ErrorViewState(),
    val transactionsLoading: Boolean = false
) {
    fun isLoading(): Boolean = transactionsLoading
}

data class ErrorViewState(val isError: Boolean = false, val message: String = "")