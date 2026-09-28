package org.thoughtcrime.securesms.compose.features.chats.conversation.ui.inputbar

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import org.thoughtcrime.securesms.compose.domain.models.AttachMenuBotModel
import org.thoughtcrime.securesms.compose.domain.models.BotCommandModel
import org.thoughtcrime.securesms.compose.domain.models.BotMenuButtonModel
import org.thoughtcrime.securesms.compose.domain.models.ChatPermissionsModel
import org.thoughtcrime.securesms.compose.domain.models.GifModel
import org.thoughtcrime.securesms.compose.domain.models.KeyboardButtonModel
import org.thoughtcrime.securesms.compose.domain.models.LinkPreviewTarget
import org.thoughtcrime.securesms.compose.domain.models.MessageEntity
import org.thoughtcrime.securesms.compose.domain.models.MessageModel
import org.thoughtcrime.securesms.compose.domain.models.MessageSendOptions
import org.thoughtcrime.securesms.compose.domain.models.PollDraft
import org.thoughtcrime.securesms.compose.domain.models.ReplyMarkupModel
import org.thoughtcrime.securesms.compose.domain.models.TdLibLimits
import org.thoughtcrime.securesms.compose.domain.models.UserModel
import org.thoughtcrime.securesms.compose.domain.models.WebPage
import org.thoughtcrime.securesms.compose.domain.repository.InlineBotResultsModel
import org.thoughtcrime.securesms.compose.domain.repository.RichTextParseMode
import org.thoughtcrime.securesms.compose.features.chats.conversation.ui.message.LinkPreviewAction
import org.thoughtcrime.securesms.compose.features.share.PendingAttachment

@Immutable
data class ChatInputBarState(
    val replyMessage: MessageModel? = null,
    val editingMessage: MessageModel? = null,
    val draftText: String = "",
    val draftLinkTargets: List<LinkPreviewTarget> = emptyList(),
    val selectedDraftLinkPreviewUrl: String? = null,
    val resolvedDraftLinkPreviewUrl: String? = null,
    val dismissedDraftLinkPreviewUrls: Set<String> = emptySet(),
    val draftLinkPreview: WebPage? = null,
    val isDraftLinkPreviewLoading: Boolean = false,
    val draftLinkPreviewError: String? = null,
    val isDraftLinkPreviewDisabledForSend: Boolean = false,
    val pendingAttachments: List<PendingAttachment> = emptyList(),
    val pendingMediaPaths: List<String> = emptyList(),
    val pendingDocumentPaths: List<String> = emptyList(),
    val isClosed: Boolean = false,
    val permissions: ChatPermissionsModel = ChatPermissionsModel(),
    val slowModeDelay: Int = 0,
    val slowModeDelayExpiresIn: Double = 0.0,
    val isCurrentUserRestricted: Boolean = false,
    val restrictedUntilDate: Int = 0,
    val isAdmin: Boolean = false,
    val isChannel: Boolean = false,
    val isBot: Boolean = false,
    val botCommands: List<BotCommandModel> = emptyList(),
    val botMenuButton: BotMenuButtonModel = BotMenuButtonModel.Default,
    val replyMarkup: ReplyMarkupModel? = null,
    val mentionSuggestions: List<UserModel> = emptyList(),
    val inlineBotResults: InlineBotResultsModel? = null,
    val currentInlineBotUsername: String? = null,
    val currentInlineQuery: String? = null,
    val isInlineBotLoading: Boolean = false,
    val attachBots: List<AttachMenuBotModel> = emptyList(),
    val scheduledMessages: List<MessageModel> = emptyList(),
    val isPremiumUser: Boolean = false,
    val isSecretChat: Boolean = false,
    val tdLibLimits: TdLibLimits = TdLibLimits(),
)

@Immutable
internal data class ChatInputBarActions(
    val onSend: (String, List<MessageEntity>, MessageSendOptions, RichTextParseMode?) -> Unit,
    val onStickerClick: (String) -> Unit = {},
    val onGifClick: (GifModel) -> Unit = {},
    val onAttachClick: () -> Unit = {},
    val onCameraClick: () -> Unit = {},
    val onSendVoice: (String, Int, ByteArray) -> Unit = { _, _, _ -> },
    val onCancelReply: () -> Unit = {},
    val onCancelEdit: () -> Unit = {},
    val onSaveEdit: (String, List<MessageEntity>, RichTextParseMode?) -> Unit = { _, _, _ -> },
    val onDraftChange: (String) -> Unit = {},
    val onSelectDraftLinkPreview: (String) -> Unit = {},
    val onDismissDraftLinkPreview: () -> Unit = {},
    val onRestoreDraftLinkPreview: () -> Unit = {},
    val onTyping: () -> Unit = {},
    val onCancelMedia: () -> Unit = {},
    val onSendAttachments: (List<PendingAttachment>, String, List<MessageEntity>, MessageSendOptions) -> Unit = { _, _, _, _ -> },
    val onPendingAttachmentsChange: (List<PendingAttachment>) -> Unit = {},
    val onMediaClick: (String) -> Unit = {},
    val onDraftLinkPreviewAction: (LinkPreviewAction) -> Unit = {},
    val onSendPoll: (PollDraft) -> Unit = {},
    val onCreateChecklist: () -> Unit = {},
    val onShowBotCommands: () -> Unit = {},
    val onReplyMarkupButtonClick: (KeyboardButtonModel) -> Unit = {},
    val onOpenMiniApp: (String, String) -> Unit = { _, _ -> },
    val onMentionQueryChange: (String?) -> Unit = {},
    val onInlineQueryChange: (String, String) -> Unit = { _, _ -> },
    val onLoadMoreInlineResults: (String) -> Unit = {},
    val onSendInlineResult: (String) -> Unit = {},
    val onInlineSwitchPm: (String, String) -> Unit = { _, _ -> },
    val onAttachBotClick: (AttachMenuBotModel) -> Unit = {},
    val onGalleryClick: () -> Unit = {},
    val onRefreshScheduledMessages: () -> Unit = {},
    val onEditScheduledMessage: (MessageModel) -> Unit = {},
    val onDeleteScheduledMessage: (MessageModel) -> Unit = {},
    val onSendScheduledNow: (MessageModel) -> Unit = {},
)

@Immutable
internal data class ChatInputBarCapabilities(
    val canWriteText: Boolean,
    val canSendPhotos: Boolean,
    val canSendVideos: Boolean,
    val canSendDocuments: Boolean,
    val canSendAudios: Boolean,
    val canOpenAttachSheet: Boolean,
    val canSendStickers: Boolean,
    val canSendVoice: Boolean,
    val canSendVideoNotes: Boolean,
    val canSendAnything: Boolean
)

@Immutable
internal data class ComposerAttachmentState(
    val pendingAttachments: List<PendingAttachment> = emptyList(),
    val pendingMediaPaths: List<String> = emptyList(),
    val pendingDocumentPaths: List<String> = emptyList(),
    val scheduledMessagesCount: Int = 0
)

@Immutable
internal data class ComposerSuggestionState(
    val mentionSuggestions: List<UserModel> = emptyList(),
    val filteredCommands: List<BotCommandModel> = emptyList(),
    val currentInlineBotUsername: String? = null,
    val isInlineBotLoading: Boolean = false,
    val inlineBotResults: InlineBotResultsModel? = null,
    val replyMarkup: ReplyMarkupModel? = null,
    val isGifSearchFocused: Boolean = false
)

@Immutable
internal data class ComposerBotState(
    val isBot: Boolean,
    val botMenuButton: BotMenuButtonModel,
    val botCommands: List<BotCommandModel>
)

@Immutable
internal data class ComposerRowState(
    val textValue: TextFieldValue,
    val editingMessage: MessageModel? = null,
    val isStickerMenuVisible: Boolean = false,
    val closeStickerMenuWithoutSlide: Boolean = false,
    val isKeyboardVisible: Boolean = false,
    val bottomInset: Dp,
    val stickerMenuHeight: Dp,
    val showFullScreenEditor: Boolean = false,
    val currentMessageLength: Int = 0,
    val maxMessageLength: Int = TdLibLimits.DEFAULT_MESSAGE_TEXT_LENGTH_MAX,
    val isOverMessageLimit: Boolean = false,
    val showSendOptionsSheet: Boolean = false,
    val isVideoMessageMode: Boolean = false,
    val isSlowModeActive: Boolean = false,
    val slowModeRemainingSeconds: Int = 0,
)

@Immutable
internal data class InputTextFieldUiState(
    val textValue: TextFieldValue,
    val isBot: Boolean,
    val botMenuButton: BotMenuButtonModel,
    val botCommands: List<BotCommandModel>,
    val canSendStickers: Boolean,
    val canWriteText: Boolean,
    val canShowBotActions: Boolean,
    val isStickerMenuVisible: Boolean,
    val canAttachMedia: Boolean,
    val canPasteMediaFromClipboard: Boolean,
    val pendingMediaPaths: List<String>,
    val pendingDocumentPaths: List<String>,
    val showExpandEditorAction: Boolean,
)

@Immutable
internal data class InputBarSendButtonState(
    val isTextEmpty: Boolean,
    val isEditing: Boolean,
    val hasPendingAttachments: Boolean,
    val isOverCharLimit: Boolean,
    val canWriteText: Boolean,
    val canSendAttachments: Boolean,
    val canSendVoice: Boolean,
    val canSendVideoNotes: Boolean,
    val isVideoMessageMode: Boolean,
    val isSlowModeActive: Boolean,
    val slowModeRemainingSeconds: Int,
)

internal enum class InputBarMode {
    Composer,
    SlowMode,
    Restricted
}
