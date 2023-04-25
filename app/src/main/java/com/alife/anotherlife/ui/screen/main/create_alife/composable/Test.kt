//package ru.rassvet.ui.general
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.pager.PageSize
//import androidx.compose.foundation.pager.VerticalPager
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//
//typealias OnChangeActivePage = (Int) -> Unit
//
//private const val HEIGHT_ONE_PAGE = 54
//private const val HEIGHT_ACTIVE_PAGE = HEIGHT_ONE_PAGE + 10
//private const val HEIGHT_PAGER = HEIGHT_ONE_PAGE * 7
//private const val NUM_START_PAGE_DAY = 5
//private const val NUM_ACTIVE_PAGE = 3
//private const val MINUTE_MULTIPLIER = 5
//private const val COUNT_PAGES_DAYS = 179
//private const val COUNT_PAGES_HOURS = 30
//private const val COUNT_PAGES_MINUTES = 18
//
//private const val SHIFT_INACTIVE_UP_PAGE_MINUTES = 9
//private const val SHIFT_INACTIVE_DOWN_PAGE_MINUTES = 15
//
//private const val SHIFT_INACTIVE_UP_PAGE_HOURS = 21
//private const val SHIFT_INACTIVE_DOWN_PAGE_HOURS = 27
//
//private const val SHIFT_ACTIVE_PAGE = 3
//private val RANGE_UP_INACTIVE_PAGES = 0..2
//
//private val RANGE_ACTIVE_MINUTE_PAGES = 3..14
//private val RANGE_DOWN_INACTIVE_MINUTE_PAGES = 15 until COUNT_PAGES_MINUTES
//
//private val RANGE_ACTIVE_HOUR_PAGES = 3..26
//private val RANGE_DOWN_INACTIVE_HOUR_PAGES = 27 until COUNT_PAGES_HOURS
//
//
//private data class DataForVerticalPager(
//    val frontData: String,
//    val numberData: Int
//)
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ViewDatePickerBottomDialog(
//    bottomSheetState: ModalBottomSheetState,
//    onClickButton: (String) -> Unit,
//    content: @Composable () -> Unit
//) {
//    val dateFormatter = DateFormatter()
//    var numDays by remember { mutableStateOf(Constants.NULL_ID) }
//    var hour by remember { mutableStateOf(Constants.NULL_ID) }
//    var minute by remember { mutableStateOf(Constants.NULL_ID) }
//    var isEnabledButton by remember { mutableStateOf(true) }
//
//    ModalBottomSheetLayout(
//        sheetShape = Theme.shapeBottomDialog,
//        sheetState = bottomSheetState,
//        content = content,
//        sheetContent = {
//            Box(
//                Modifier
//                    .fillMaxWidth()
//                    .navigationBarsPadding()
//            ) {
//                ViewTitle()
//                Column(verticalArrangement = Arrangement.Center) {
//                    Spacer(Modifier.height(50.dep()))
//                    ViewRowPagers(
//                        dateFormatter = dateFormatter,
//                        onChangeActiveDay = {
//                            numDays = it
//                            isEnabledButton = isEnabledButton(dateFormatter, numDays, hour, minute)
//                        },
//                        onChangeActiveHour = {
//                            hour = it
//                            isEnabledButton = isEnabledButton(dateFormatter, numDays, hour, minute)
//                        },
//                        onChangeActiveMinute = {
//                            minute = it
//                            isEnabledButton = isEnabledButton(dateFormatter, numDays, hour, minute)
//                        }
//                    )
//                    Spacer(Modifier.height(60.dep()))
//                }
//                ViewAppButton(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .align(Alignment.BottomCenter)
//                        .padding(24.dep()),
//                    isEnabled = isEnabledButton,
//                    buttonValue = TextValue.StringIdValue(R.string.bottom_dialog_data_picker_button),
//                    buttonColors = Theme.buttonColors.appButtonOrange,
//                    onClick = {
//                        val dateRequestFormat =
//                            dateFormatter.createDateRequestFormat(numDays, minute, hour)
//                        onClickButton(dateRequestFormat)
//                    }
//                )
//            }
//        }
//    )
//}
//
//private fun isEnabledButton(
//    dateFormatter: DateFormatter,
//    numDays: Int,
//    hour: Int,
//    minute: Int
//): Boolean {
//    val actualDate = dateFormatter.getActualDate()
//    return when {
//        numDays == Constants.MNP_ACTUAL_NUM_DAY && (hour - actualDate.hour) == 0 -> minute >= actualDate.minute
//        numDays == Constants.MNP_ACTUAL_NUM_DAY -> (hour - actualDate.hour) >= 1
//        numDays > Constants.MNP_ACTUAL_NUM_DAY -> true
//        else -> false
//    }
//}
//
//@Composable
//private fun ViewTitle() {
//    Text(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 24.dep(), vertical = 26.dep()),
//        text = stringResource(R.string.bottom_dialog_data_picker_title),
//        style = Theme.typography.titleGrayBox,
//        color = Theme.colors.onBackground
//    )
//}
//
//@Composable
//private fun ViewRowPagers(
//    dateFormatter: DateFormatter,
//    onChangeActiveDay: OnChangeActivePage,
//    onChangeActiveHour: OnChangeActivePage,
//    onChangeActiveMinute: OnChangeActivePage,
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(HEIGHT_PAGER.dep()),
//        horizontalArrangement = Arrangement.Center
//    ) {
//        ViewVerticalPager(
//            count = COUNT_PAGES_DAYS,
//            modifier = Modifier.weight(1f),
//            initialPage = 0,
//            onChangeActivePage = onChangeActiveDay,
//            getDataForVerticalPager = { numCount ->
//                val numDays = numCount + NUM_START_PAGE_DAY
//                DataForVerticalPager(
//                    frontData = dateFormatter.datePickerFormat(numDays),
//                    numberData = numDays
//                )
//            }
//        )
//        Spacer(Modifier.width(4.dep()))
//        ViewVerticalPager(
//            count = COUNT_PAGES_HOURS,
//            initialPage = dateFormatter.getActualDate().hour,
//            modifier = Modifier.width(95.dep()),
//            onChangeActivePage = onChangeActiveHour,
//            getDataForVerticalPager = { getHourDataForVerticalPager(it) }
//        )
//        Spacer(Modifier.width(4.dep()))
//        ViewVerticalPager(
//            count = COUNT_PAGES_MINUTES,
//            initialPage = getMinuteInitialPage(dateFormatter),
//            modifier = Modifier.width(95.dep()),
//            onChangeActivePage = onChangeActiveMinute,
//            getDataForVerticalPager = { getMinuteDataForVerticalPager(it) }
//        )
//    }
//}
//
//private fun getMinuteInitialPage(dateFormatter: DateFormatter): Int {
//    return when (dateFormatter.getActualDate().minute) {
//        in 0..5 -> 1
//        in 6..10 -> 2
//        in 11..15 -> 3
//        in 16..20 -> 4
//        in 21..25 -> 5
//        in 26..30 -> 6
//        in 31..35 -> 7
//        in 36..40 -> 8
//        in 41..45 -> 9
//        in 46..50 -> 10
//        else -> 11
//    }
//}
//
//private fun getHourDataForVerticalPager(numCount: Int): DataForVerticalPager {
//    val hour = when (numCount) {
//        in RANGE_UP_INACTIVE_PAGES ->
//            (numCount + SHIFT_INACTIVE_UP_PAGE_HOURS)
//
//        in RANGE_ACTIVE_HOUR_PAGES ->
//            (numCount - SHIFT_ACTIVE_PAGE)
//
//        in RANGE_DOWN_INACTIVE_HOUR_PAGES ->
//            (numCount - SHIFT_INACTIVE_DOWN_PAGE_HOURS)
//
//        else -> Constants.NULL_AMOUNT
//    }
//    return DataForVerticalPager(
//        frontData = hour.numString(),
//        numberData = hour
//    )
//}
//
//private fun getMinuteDataForVerticalPager(numCount: Int): DataForVerticalPager {
//    val minute = when (numCount) {
//        in RANGE_UP_INACTIVE_PAGES ->
//            (numCount + SHIFT_INACTIVE_UP_PAGE_MINUTES) * MINUTE_MULTIPLIER
//
//        in RANGE_ACTIVE_MINUTE_PAGES ->
//            (numCount - SHIFT_ACTIVE_PAGE) * MINUTE_MULTIPLIER
//
//        in RANGE_DOWN_INACTIVE_MINUTE_PAGES ->
//            (numCount - SHIFT_INACTIVE_DOWN_PAGE_MINUTES) * MINUTE_MULTIPLIER
//
//        else -> Constants.NULL_AMOUNT
//    }
//    return DataForVerticalPager(
//        frontData = minute.numString(),
//        numberData = minute
//    )
//}
//
//@Composable
//@OptIn(ExperimentalFoundationApi::class)
//private fun ViewVerticalPager(
//    modifier: Modifier,
//    count: Int,
//    initialPage: Int,
//    getDataForVerticalPager: (Int) -> DataForVerticalPager,
//    onChangeActivePage: OnChangeActivePage
//) {
//    val pagerState = rememberPagerState(initialPage)
//
//    var countActivePage by remember {
//        mutableStateOf(-1)
//    }
//    LaunchedEffect(countActivePage) {
//        val numberData = getDataForVerticalPager.invoke(countActivePage).numberData
//        onChangeActivePage(numberData)
//    }
//
//    Box(modifier = modifier.fillMaxHeight()) {
//        VerticalPager(
//            modifier = Modifier.align(Alignment.Center),
//            pageCount = count,
//            state = pagerState,
//            pageSize = PageSize.Fixed(HEIGHT_ONE_PAGE.dep()),
//        ) {
//            countActivePage = pagerState.currentPage % count + NUM_ACTIVE_PAGE
//            val pageValue = getDataForVerticalPager.invoke(it % count).frontData
//            ViewItemPage(pageValue)
//        }
//        ViewMaskPage()
//    }
//}
//
//@Composable
//private fun BoxScope.ViewMaskPage() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .align(Alignment.Center),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ViewGradientMask(
//            listColor = listOf(
//                Color.White.copy(alpha = 0.95f),
//                Color.White.copy(alpha = 0.6f),
//            )
//        )
//        ViewActivePageMask()
//        ViewGradientMask(
//            listColor = listOf(
//                Color.White.copy(alpha = 0.6f),
//                Color.White.copy(alpha = 0.95f),
//            )
//        )
//    }
//}
//
//@Composable
//private fun ViewActivePageMask() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(HEIGHT_ACTIVE_PAGE.dep())
//            .background(Theme.colors.onBackground.copy(alpha = 0.1f))
//    )
//}
//
//@Composable
//private fun ColumnScope.ViewGradientMask(listColor: List<Color>) {
//    Box(
//        modifier = Modifier
//            .weight(1f)
//            .fillMaxWidth()
//            .background(Brush.verticalGradient(listColor))
//    )
//}
//
//@Composable
//private fun ViewItemPage(value: String) {
//    Box(
//        modifier = Modifier.fillMaxWidth(),
//        content = {
//            Text(
//                modifier = Modifier.align(Alignment.Center),
//                text = value,
//                style = Theme.typography.titleOtherScreen,
//                color = Theme.colors.onBackground.copy(alpha = 0.6f),
//                textAlign = TextAlign.Center,
//            )
//        }
//    )
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    AppTheme {
//        ViewDatePickerBottomDialog(
//            bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded),
//            onClickButton = {},
//            content = {}
//        )
//    }
//}