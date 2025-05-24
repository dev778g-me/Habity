package com.dev.habity.Model.Utils

import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryChip(
    text : String,
    enabled : Boolean,
    selected : Boolean,
    onClick : () -> Unit,
) {
    FilterChip(
        selected = selected,
        enabled = enabled,
        onClick = onClick,
        label = {
            Text(text= text)
        }
    )
}