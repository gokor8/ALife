package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

interface NavigationBarItemComposable {

    @Composable
    fun Content(rowScope: RowScope, selected: Boolean)


    class Abstract(
        @StringRes icon: Int,

        ) : NavigationBarItemComposable {

        // Запихивается в кастомный лист, где оборачивается в обертки модели(лсита Node),
        // которые содержат в себе позицию, и д такую же функцию(rowScope, positon), выдают ответ проверки
        @Composable
        override fun Content(rowScope: RowScope, selected: Boolean) {
            rowScope.NavigationBarItem(
                selected = selected,
                onClick = {  }
            )
        }
    }
}