package ru.rabbit.persian.actionSheet

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.rabbit.persian.foundation.elevation
import ru.rabbit.persian.foundation.spacing

object PersianActionSheet {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        actions: List<ActionItem>,
        sheetState: SheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        ),
        onDismissRequest: () -> Unit
    ) {
        ModalBottomSheet(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    horizontal = MaterialTheme.spacing.large,
                    vertical = MaterialTheme.spacing.small
                ).border(1.dp, Color.Red),
            onDismissRequest = onDismissRequest,
            shape = MaterialTheme.shapes.large,
            sheetState = sheetState,
            dragHandle = null,
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = MaterialTheme.elevation.extraSmall,
            content = {
                actions.forEach {
                    PersianActionItem.Primary(actionItem = it)
                }
            }
        )
    }

}