package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.webapp.InvoiceModel

interface PaymentRepository {
    suspend fun getInvoice(slug: String? = null, chatId: Long? = null, messageId: Long? = null): InvoiceModel?

    suspend fun payInvoice(slug: String? = null, chatId: Long? = null, messageId: Long? = null): Boolean

    suspend fun onCallbackQueryBuy(chatId: Long, messageId: Long)
}