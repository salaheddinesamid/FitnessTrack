package com.example.fitnesstrack.ui.components

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Swipeable(
    pages: List<@Composable ()-> Unit>
) {
    val pagerState = rememberPagerState { pages.size }

    HorizontalPager(state = pagerState) { page ->
        pages[page]()
    }
}

@Preview(showBackground = true)
@Composable
fun SwipeablePreview(){

}