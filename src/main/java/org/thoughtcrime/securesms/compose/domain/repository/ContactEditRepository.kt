package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.UserModel

interface ContactEditRepository {
    suspend fun getContact(userId: Long): UserModel?
    suspend fun getNeedPhoneNumberPrivacyException(userId: Long): Boolean
    suspend fun upsertContact(
        user: UserModel,
        sharePhoneNumber: Boolean
    ): UserModel?

    suspend fun removeContact(userId: Long)
    suspend fun setCloseFriend(
        userId: Long,
        isCloseFriend: Boolean
    ): UserModel?

    val supportsPersonalPhotoEditing: Boolean
        get() = false
}
