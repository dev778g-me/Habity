package com.example.compose
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.dev.habity.View.theme.backgroundDark
import com.dev.habity.View.theme.backgroundDarkHighContrast
import com.dev.habity.View.theme.backgroundDarkMediumContrast
import com.dev.habity.View.theme.backgroundLight
import com.dev.habity.View.theme.backgroundLightHighContrast
import com.dev.habity.View.theme.backgroundLightMediumContrast
import com.dev.habity.View.theme.errorContainerDark
import com.dev.habity.View.theme.errorContainerDarkHighContrast
import com.dev.habity.View.theme.errorContainerDarkMediumContrast
import com.dev.habity.View.theme.errorContainerLight
import com.dev.habity.View.theme.errorContainerLightHighContrast
import com.dev.habity.View.theme.errorContainerLightMediumContrast
import com.dev.habity.View.theme.errorDark
import com.dev.habity.View.theme.errorDarkHighContrast
import com.dev.habity.View.theme.errorDarkMediumContrast
import com.dev.habity.View.theme.errorLight
import com.dev.habity.View.theme.errorLightHighContrast
import com.dev.habity.View.theme.errorLightMediumContrast
import com.dev.habity.View.theme.inverseOnSurfaceDark
import com.dev.habity.View.theme.inverseOnSurfaceDarkHighContrast
import com.dev.habity.View.theme.inverseOnSurfaceDarkMediumContrast
import com.dev.habity.View.theme.inverseOnSurfaceLight
import com.dev.habity.View.theme.inverseOnSurfaceLightHighContrast
import com.dev.habity.View.theme.inverseOnSurfaceLightMediumContrast
import com.dev.habity.View.theme.inversePrimaryDark
import com.dev.habity.View.theme.inversePrimaryDarkHighContrast
import com.dev.habity.View.theme.inversePrimaryDarkMediumContrast
import com.dev.habity.View.theme.inversePrimaryLight
import com.dev.habity.View.theme.inversePrimaryLightHighContrast
import com.dev.habity.View.theme.inversePrimaryLightMediumContrast
import com.dev.habity.View.theme.inverseSurfaceDark
import com.dev.habity.View.theme.inverseSurfaceDarkHighContrast
import com.dev.habity.View.theme.inverseSurfaceDarkMediumContrast
import com.dev.habity.View.theme.inverseSurfaceLight
import com.dev.habity.View.theme.inverseSurfaceLightHighContrast
import com.dev.habity.View.theme.inverseSurfaceLightMediumContrast
import com.dev.habity.View.theme.onBackgroundDark
import com.dev.habity.View.theme.onBackgroundDarkHighContrast
import com.dev.habity.View.theme.onBackgroundDarkMediumContrast
import com.dev.habity.View.theme.onBackgroundLight
import com.dev.habity.View.theme.onBackgroundLightHighContrast
import com.dev.habity.View.theme.onBackgroundLightMediumContrast
import com.dev.habity.View.theme.onErrorContainerDark
import com.dev.habity.View.theme.onErrorContainerDarkHighContrast
import com.dev.habity.View.theme.onErrorContainerDarkMediumContrast
import com.dev.habity.View.theme.onErrorContainerLight
import com.dev.habity.View.theme.onErrorContainerLightHighContrast
import com.dev.habity.View.theme.onErrorContainerLightMediumContrast
import com.dev.habity.View.theme.onErrorDark
import com.dev.habity.View.theme.onErrorDarkHighContrast
import com.dev.habity.View.theme.onErrorDarkMediumContrast
import com.dev.habity.View.theme.onErrorLight
import com.dev.habity.View.theme.onErrorLightHighContrast
import com.dev.habity.View.theme.onErrorLightMediumContrast
import com.dev.habity.View.theme.onPrimaryContainerDark
import com.dev.habity.View.theme.onPrimaryContainerDarkHighContrast
import com.dev.habity.View.theme.onPrimaryContainerDarkMediumContrast
import com.dev.habity.View.theme.onPrimaryContainerLight
import com.dev.habity.View.theme.onPrimaryContainerLightHighContrast
import com.dev.habity.View.theme.onPrimaryContainerLightMediumContrast
import com.dev.habity.View.theme.onPrimaryDark
import com.dev.habity.View.theme.onPrimaryDarkHighContrast
import com.dev.habity.View.theme.onPrimaryDarkMediumContrast
import com.dev.habity.View.theme.onPrimaryLight
import com.dev.habity.View.theme.onPrimaryLightHighContrast
import com.dev.habity.View.theme.onPrimaryLightMediumContrast
import com.dev.habity.View.theme.onSecondaryContainerDark
import com.dev.habity.View.theme.onSecondaryContainerDarkHighContrast
import com.dev.habity.View.theme.onSecondaryContainerDarkMediumContrast
import com.dev.habity.View.theme.onSecondaryContainerLight
import com.dev.habity.View.theme.onSecondaryContainerLightHighContrast
import com.dev.habity.View.theme.onSecondaryContainerLightMediumContrast
import com.dev.habity.View.theme.onSecondaryDark
import com.dev.habity.View.theme.onSecondaryDarkHighContrast
import com.dev.habity.View.theme.onSecondaryDarkMediumContrast
import com.dev.habity.View.theme.onSecondaryLight
import com.dev.habity.View.theme.onSecondaryLightHighContrast
import com.dev.habity.View.theme.onSecondaryLightMediumContrast
import com.dev.habity.View.theme.onSurfaceDark
import com.dev.habity.View.theme.onSurfaceDarkHighContrast
import com.dev.habity.View.theme.onSurfaceDarkMediumContrast
import com.dev.habity.View.theme.onSurfaceLight
import com.dev.habity.View.theme.onSurfaceLightHighContrast
import com.dev.habity.View.theme.onSurfaceLightMediumContrast
import com.dev.habity.View.theme.onSurfaceVariantDark
import com.dev.habity.View.theme.onSurfaceVariantDarkHighContrast
import com.dev.habity.View.theme.onSurfaceVariantDarkMediumContrast
import com.dev.habity.View.theme.onSurfaceVariantLight
import com.dev.habity.View.theme.onSurfaceVariantLightHighContrast
import com.dev.habity.View.theme.onSurfaceVariantLightMediumContrast
import com.dev.habity.View.theme.onTertiaryContainerDark
import com.dev.habity.View.theme.onTertiaryContainerDarkHighContrast
import com.dev.habity.View.theme.onTertiaryContainerDarkMediumContrast
import com.dev.habity.View.theme.onTertiaryContainerLight
import com.dev.habity.View.theme.onTertiaryContainerLightHighContrast
import com.dev.habity.View.theme.onTertiaryContainerLightMediumContrast
import com.dev.habity.View.theme.onTertiaryDark
import com.dev.habity.View.theme.onTertiaryDarkHighContrast
import com.dev.habity.View.theme.onTertiaryDarkMediumContrast
import com.dev.habity.View.theme.onTertiaryLight
import com.dev.habity.View.theme.onTertiaryLightHighContrast
import com.dev.habity.View.theme.onTertiaryLightMediumContrast
import com.dev.habity.View.theme.outlineDark
import com.dev.habity.View.theme.outlineDarkHighContrast
import com.dev.habity.View.theme.outlineDarkMediumContrast
import com.dev.habity.View.theme.outlineLight
import com.dev.habity.View.theme.outlineLightHighContrast
import com.dev.habity.View.theme.outlineLightMediumContrast
import com.dev.habity.View.theme.outlineVariantDark
import com.dev.habity.View.theme.outlineVariantDarkHighContrast
import com.dev.habity.View.theme.outlineVariantDarkMediumContrast
import com.dev.habity.View.theme.outlineVariantLight
import com.dev.habity.View.theme.outlineVariantLightHighContrast
import com.dev.habity.View.theme.outlineVariantLightMediumContrast
import com.dev.habity.View.theme.primaryContainerDark
import com.dev.habity.View.theme.primaryContainerDarkHighContrast
import com.dev.habity.View.theme.primaryContainerDarkMediumContrast
import com.dev.habity.View.theme.primaryContainerLight
import com.dev.habity.View.theme.primaryContainerLightHighContrast
import com.dev.habity.View.theme.primaryContainerLightMediumContrast
import com.dev.habity.View.theme.primaryDark
import com.dev.habity.View.theme.primaryDarkHighContrast
import com.dev.habity.View.theme.primaryDarkMediumContrast
import com.dev.habity.View.theme.primaryLight
import com.dev.habity.View.theme.primaryLightHighContrast
import com.dev.habity.View.theme.primaryLightMediumContrast
import com.dev.habity.View.theme.scrimDark
import com.dev.habity.View.theme.scrimDarkHighContrast
import com.dev.habity.View.theme.scrimDarkMediumContrast
import com.dev.habity.View.theme.scrimLight
import com.dev.habity.View.theme.scrimLightHighContrast
import com.dev.habity.View.theme.scrimLightMediumContrast
import com.dev.habity.View.theme.secondaryContainerDark
import com.dev.habity.View.theme.secondaryContainerDarkHighContrast
import com.dev.habity.View.theme.secondaryContainerDarkMediumContrast
import com.dev.habity.View.theme.secondaryContainerLight
import com.dev.habity.View.theme.secondaryContainerLightHighContrast
import com.dev.habity.View.theme.secondaryContainerLightMediumContrast
import com.dev.habity.View.theme.secondaryDark
import com.dev.habity.View.theme.secondaryDarkHighContrast
import com.dev.habity.View.theme.secondaryDarkMediumContrast
import com.dev.habity.View.theme.secondaryLight
import com.dev.habity.View.theme.secondaryLightHighContrast
import com.dev.habity.View.theme.secondaryLightMediumContrast
import com.dev.habity.View.theme.surfaceBrightDark
import com.dev.habity.View.theme.surfaceBrightDarkHighContrast
import com.dev.habity.View.theme.surfaceBrightDarkMediumContrast
import com.dev.habity.View.theme.surfaceBrightLight
import com.dev.habity.View.theme.surfaceBrightLightHighContrast
import com.dev.habity.View.theme.surfaceBrightLightMediumContrast
import com.dev.habity.View.theme.surfaceContainerDark
import com.dev.habity.View.theme.surfaceContainerDarkHighContrast
import com.dev.habity.View.theme.surfaceContainerDarkMediumContrast
import com.dev.habity.View.theme.surfaceContainerHighDark
import com.dev.habity.View.theme.surfaceContainerHighDarkHighContrast
import com.dev.habity.View.theme.surfaceContainerHighDarkMediumContrast
import com.dev.habity.View.theme.surfaceContainerHighLight
import com.dev.habity.View.theme.surfaceContainerHighLightHighContrast
import com.dev.habity.View.theme.surfaceContainerHighLightMediumContrast
import com.dev.habity.View.theme.surfaceContainerHighestDark
import com.dev.habity.View.theme.surfaceContainerHighestDarkHighContrast
import com.dev.habity.View.theme.surfaceContainerHighestDarkMediumContrast
import com.dev.habity.View.theme.surfaceContainerHighestLight
import com.dev.habity.View.theme.surfaceContainerHighestLightHighContrast
import com.dev.habity.View.theme.surfaceContainerHighestLightMediumContrast
import com.dev.habity.View.theme.surfaceContainerLight
import com.dev.habity.View.theme.surfaceContainerLightHighContrast
import com.dev.habity.View.theme.surfaceContainerLightMediumContrast
import com.dev.habity.View.theme.surfaceContainerLowDark
import com.dev.habity.View.theme.surfaceContainerLowDarkHighContrast
import com.dev.habity.View.theme.surfaceContainerLowDarkMediumContrast
import com.dev.habity.View.theme.surfaceContainerLowLight
import com.dev.habity.View.theme.surfaceContainerLowLightHighContrast
import com.dev.habity.View.theme.surfaceContainerLowLightMediumContrast
import com.dev.habity.View.theme.surfaceContainerLowestDark
import com.dev.habity.View.theme.surfaceContainerLowestDarkHighContrast
import com.dev.habity.View.theme.surfaceContainerLowestDarkMediumContrast
import com.dev.habity.View.theme.surfaceContainerLowestLight
import com.dev.habity.View.theme.surfaceContainerLowestLightHighContrast
import com.dev.habity.View.theme.surfaceContainerLowestLightMediumContrast
import com.dev.habity.View.theme.surfaceDark
import com.dev.habity.View.theme.surfaceDarkHighContrast
import com.dev.habity.View.theme.surfaceDarkMediumContrast
import com.dev.habity.View.theme.surfaceDimDark
import com.dev.habity.View.theme.surfaceDimDarkHighContrast
import com.dev.habity.View.theme.surfaceDimDarkMediumContrast
import com.dev.habity.View.theme.surfaceDimLight
import com.dev.habity.View.theme.surfaceDimLightHighContrast
import com.dev.habity.View.theme.surfaceDimLightMediumContrast
import com.dev.habity.View.theme.surfaceLight
import com.dev.habity.View.theme.surfaceLightHighContrast
import com.dev.habity.View.theme.surfaceLightMediumContrast
import com.dev.habity.View.theme.surfaceVariantDark
import com.dev.habity.View.theme.surfaceVariantDarkHighContrast
import com.dev.habity.View.theme.surfaceVariantDarkMediumContrast
import com.dev.habity.View.theme.surfaceVariantLight
import com.dev.habity.View.theme.surfaceVariantLightHighContrast
import com.dev.habity.View.theme.surfaceVariantLightMediumContrast
import com.dev.habity.View.theme.tertiaryContainerDark
import com.dev.habity.View.theme.tertiaryContainerDarkHighContrast
import com.dev.habity.View.theme.tertiaryContainerDarkMediumContrast
import com.dev.habity.View.theme.tertiaryContainerLight
import com.dev.habity.View.theme.tertiaryContainerLightHighContrast
import com.dev.habity.View.theme.tertiaryContainerLightMediumContrast
import com.dev.habity.View.theme.tertiaryDark
import com.dev.habity.View.theme.tertiaryDarkHighContrast
import com.dev.habity.View.theme.tertiaryDarkMediumContrast
import com.dev.habity.View.theme.tertiaryLight
import com.dev.habity.View.theme.tertiaryLightHighContrast
import com.dev.habity.View.theme.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun HabityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

