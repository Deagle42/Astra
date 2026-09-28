package org.thoughtcrime.securesms.compose.settings.chatSettings

import android.graphics.Color.HSVToColor
import android.graphics.Color.colorToHSV
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.thoughtcrime.securesms.compose.domain.managers.AssetsManager
import org.thoughtcrime.securesms.compose.domain.managers.DistrManager
import org.thoughtcrime.securesms.compose.domain.models.WallpaperModel
import org.thoughtcrime.securesms.compose.domain.repository.EmojiRepository
import org.thoughtcrime.securesms.compose.domain.repository.StickerRepository
import org.thoughtcrime.securesms.compose.domain.repository.WallpaperRepository
import org.thoughtcrime.securesms.compose.core.util.AppPreferences
import org.thoughtcrime.securesms.compose.core.util.EmojiStyle
import org.thoughtcrime.securesms.compose.core.util.IDownloadUtils
import org.thoughtcrime.securesms.compose.core.util.NightMode
import org.thoughtcrime.securesms.compose.core.util.coRunCatching
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext
import java.io.File
import java.net.URL

interface ChatSettingsComponent {
    val state: Value<State>
    val downloadUtils: IDownloadUtils
    fun onBackClicked()
    fun onFontSizeChanged(size: Float)
    fun onLetterSpacingChanged(size: Float)
    fun onBubbleRadiusChanged(radius: Float)
    fun onStickerSizeChanged(size: Float)
    fun onWallpaperChanged(wallpaper: String?)
    fun onWallpaperSelected(wallpaper: WallpaperModel)
    fun onWallpaperUpload(path: String)
    fun onWallpaperBlurChanged(wallpaper: WallpaperModel, isBlurred: Boolean)
    fun onWallpaperBlurIntensityChanged(intensity: Int)
    fun onWallpaperMotionChanged(wallpaper: WallpaperModel, isMoving: Boolean)
    fun onWallpaperDimmingChanged(dimming: Int)
    fun onWallpaperGrayscaleChanged(isGrayscale: Boolean)
    fun onPlayerGesturesEnabledChanged(enabled: Boolean)
    fun onPlayerDoubleTapSeekEnabledChanged(enabled: Boolean)
    fun onPlayerSeekDurationChanged(duration: Int)
    fun onPlayerZoomEnabledChanged(enabled: Boolean)
    fun onClearRecentStickers()
    fun onClearRecentEmojis()
    fun onArchivePinnedChanged(pinned: Boolean)
    fun onArchiveAlwaysVisibleChanged(enabled: Boolean)
    fun onShowLinkPreviewsChanged(enabled: Boolean)
    fun onFixLinkPreviewsChanged(enabled: Boolean)
    fun onNightModeChanged(mode: NightMode)
    fun onDynamicColorsChanged(enabled: Boolean)
    fun onAmoledThemeChanged(enabled: Boolean)
    fun onCustomThemeEnabledChanged(enabled: Boolean)
    fun onThemePrimaryColorChanged(color: Int)
    fun onThemeSecondaryColorChanged(color: Int)
    fun onThemeTertiaryColorChanged(color: Int)
    fun onThemeBackgroundColorChanged(color: Int)
    fun onThemeSurfaceColorChanged(color: Int)
    fun onThemePrimaryContainerColorChanged(color: Int)
    fun onThemeSecondaryContainerColorChanged(color: Int)
    fun onThemeTertiaryContainerColorChanged(color: Int)
    fun onThemeSurfaceVariantColorChanged(color: Int)
    fun onThemeOutlineColorChanged(color: Int)
    fun onThemeDarkPrimaryColorChanged(color: Int)
    fun onThemeDarkSecondaryColorChanged(color: Int)
    fun onThemeDarkTertiaryColorChanged(color: Int)
    fun onThemeDarkBackgroundColorChanged(color: Int)
    fun onThemeDarkSurfaceColorChanged(color: Int)
    fun onThemeDarkPrimaryContainerColorChanged(color: Int)
    fun onThemeDarkSecondaryContainerColorChanged(color: Int)
    fun onThemeDarkTertiaryContainerColorChanged(color: Int)
    fun onThemeDarkSurfaceVariantColorChanged(color: Int)
    fun onThemeDarkOutlineColorChanged(color: Int)
    fun onApplyThemeAccent(color: Int, darkPalette: Boolean)
    fun exportCustomThemeJson(): String
    fun importCustomThemeJson(json: String): Boolean
    fun onNightModeStartTimeChanged(time: String)
    fun onNightModeEndTimeChanged(time: String)
    fun onNightModeBrightnessThresholdChanged(threshold: Float)
    fun onDragToBackChanged(enabled: Boolean)
    fun onInAppBrowserEnabledChanged(enabled: Boolean)
    fun onTabletInterfaceEnabledChanged(enabled: Boolean)
    fun onEmojiStyleChanged(style: EmojiStyle)
    fun onEmojiStyleLongClick(style: EmojiStyle)
    fun onConfirmRemoveEmojiPack()
    fun onDismissRemoveEmojiPack()
    fun onCompressPhotosChanged(enabled: Boolean)
    fun onCompressVideosChanged(enabled: Boolean)
    fun onChatListMessageLinesChanged(lines: Int)
    fun onShowChatListPhotosChanged(enabled: Boolean)
    fun onShowStoriesBlockChanged(enabled: Boolean)
    fun onShowReactionsChanged(enabled: Boolean)

    data class State(
        val fontSize: Float = 16f,
        val letterSpacing: Float = 0f,
        val bubbleRadius: Float = 18f,
        val stickerSize: Float = 200f,
        val wallpaper: String? = null,
        val isWallpaperBlurred: Boolean = false,
        val wallpaperBlurIntensity: Int = 20,
        val isWallpaperMoving: Boolean = false,
        val wallpaperDimming: Int = 0,
        val isWallpaperGrayscale: Boolean = false,
        val isWallpaperUploading: Boolean = false,
        val availableWallpapers: List<WallpaperModel> = emptyList(),
        val selectedWallpaper: WallpaperModel? = null,
        val isPlayerGesturesEnabled: Boolean = true,
        val isPlayerDoubleTapSeekEnabled: Boolean = true,
        val playerSeekDuration: Int = 10,
        val isPlayerZoomEnabled: Boolean = true,
        val isArchivePinned: Boolean = true,
        val isArchiveAlwaysVisible: Boolean = false,
        val showLinkPreviews: Boolean = true,
        val fixLinkPreviews: Boolean = true,
        val nightMode: NightMode = NightMode.SYSTEM,
        val isDynamicColorsEnabled: Boolean = true,
        val isAmoledThemeEnabled: Boolean = false,
        val isCustomThemeEnabled: Boolean = false,
        val themePrimaryColor: Int = 0xFF3390EC.toInt(),
        val themeSecondaryColor: Int = 0xFF4C7599.toInt(),
        val themeTertiaryColor: Int = 0xFF00ACC1.toInt(),
        val themeBackgroundColor: Int = 0xFFFFFBFE.toInt(),
        val themeSurfaceColor: Int = 0xFFFFFBFE.toInt(),
        val themePrimaryContainerColor: Int = 0xFFD4E3FF.toInt(),
        val themeSecondaryContainerColor: Int = 0xFFD0E4F7.toInt(),
        val themeTertiaryContainerColor: Int = 0xFFC4EEF4.toInt(),
        val themeSurfaceVariantColor: Int = 0xFFE1E2EC.toInt(),
        val themeOutlineColor: Int = 0xFF757680.toInt(),
        val themeDarkPrimaryColor: Int = 0xFF64B5F6.toInt(),
        val themeDarkSecondaryColor: Int = 0xFF81A9CA.toInt(),
        val themeDarkTertiaryColor: Int = 0xFF4DD0E1.toInt(),
        val themeDarkBackgroundColor: Int = 0xFF121212.toInt(),
        val themeDarkSurfaceColor: Int = 0xFF121212.toInt(),
        val themeDarkPrimaryContainerColor: Int = 0xFF224A77.toInt(),
        val themeDarkSecondaryContainerColor: Int = 0xFF334F65.toInt(),
        val themeDarkTertiaryContainerColor: Int = 0xFF1E636F.toInt(),
        val themeDarkSurfaceVariantColor: Int = 0xFF44474F.toInt(),
        val themeDarkOutlineColor: Int = 0xFF8E9099.toInt(),
        val nightModeStartTime: String = "22:00",
        val nightModeEndTime: String = "07:00",
        val nightModeBrightnessThreshold: Float = 0.2f,
        val isDragToBackEnabled: Boolean = true,
        val inAppBrowserEnabled: Boolean = true,
        val isTabletInterfaceEnabled: Boolean = true,
        val emojiStyle: EmojiStyle = EmojiStyle.SYSTEM,
        val isAppleEmojiDownloaded: Boolean = false,
        val isTwitterEmojiDownloaded: Boolean = false,
        val isWindowsEmojiDownloaded: Boolean = false,
        val isCatmojiEmojiDownloaded: Boolean = false,
        val isNotoEmojiDownloaded: Boolean = false,
        val isAppleEmojiDownloading: Boolean = false,
        val isTwitterEmojiDownloading: Boolean = false,
        val isWindowsEmojiDownloading: Boolean = false,
        val isCatmojiEmojiDownloading: Boolean = false,
        val isNotoEmojiDownloading: Boolean = false,
        val emojiPackToRemove: EmojiStyle? = null,
        val compressPhotos: Boolean = true,
        val compressVideos: Boolean = true,
        val chatListMessageLines: Int = 1,
        val showChatListPhotos: Boolean = true,
        val showStoriesBlock: Boolean = true,
        val showReactions: Boolean = true,
        val isInstalledFromGooglePlay: Boolean = true
    )
}
