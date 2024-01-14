package com.ichwan.learn.composeessential.basic.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i", false) }

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
){
    LazyColumn(modifier = modifier) {
        items(list, key = {task -> task.id}) {
            task  ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked)},
                onClose = { onCloseTask(task) }) }
    }
}