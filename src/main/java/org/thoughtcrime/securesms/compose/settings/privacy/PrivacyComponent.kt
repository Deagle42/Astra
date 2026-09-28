package org.thoughtcrime.securesms.compose.settings.privacy

import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyKey
import org.thoughtcrime.securesms.compose.domain.repository.PrivacyRepository
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext
import org.thoughtcrime.securesms.compose.settings.privacy.userSelection.UserSelectionComponent

interface PrivacyComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class ListChild(val component: PrivacyListComponent) : Child()
        class SettingChild(val component: PrivacySettingComponent) : Child()
        class BlockedUsersChild(val component: BlockedUsersComponent) : Child()
        class UserSelectionChild(val component: UserSelectionComponent) : Child()
    }
}