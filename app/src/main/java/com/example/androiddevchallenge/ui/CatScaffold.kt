package com.example.androiddevchallenge.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.topBarColor
import com.example.androiddevchallenge.viewmodels.CatListViewModel
import kotlinx.coroutines.launch

@Preview("Cat Scaffold")
@Composable
fun CatScaffold(navController: NavController? = null) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(DrawerValue.Closed)
    )
    val fabShape = CutCornerShape(16.dp)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { CatTopBar() },
        bottomBar = { CatBottomBar(fabShape) },
        snackbarHost = { state -> CatSnackBarHost(state) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = { CatFloatingActionButton(scaffoldState, fabShape) },
        content = { CatContent(navController) },
    )
}

@Composable
fun CatTopBar() {
    TopAppBar(
        title = { Text("Top AppBar") },
        backgroundColor = topBarColor,
    )
}

@Composable
fun CatBottomBar(fabShape: CutCornerShape) {
    BottomAppBar(
        backgroundColor = topBarColor,
        cutoutShape = fabShape
    ) {
        Text("BottomAppBar")
    }
}

@Composable
fun CatSnackBarHost(state: SnackbarHostState) {
    SnackbarHost(
        state,
        snackbar = { data ->
            Snackbar(
                data,
                backgroundColor = Color(0x99000000),
                elevation = 1.dp
            )
        })
}

@Composable
fun CatFloatingActionButton(scaffoldState: ScaffoldState, fabShape: CutCornerShape) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(shape = fabShape, onClick = {
        scope.launch {
            when (scaffoldState.snackbarHostState.showSnackbar(
                message = "Snackbar",
                actionLabel = "Ok"
            )) {
                SnackbarResult.Dismissed -> Log.d("Track", "Dismissed")
                SnackbarResult.ActionPerformed -> Log.d("Track", "Action!")
            }
        }

    }) {
        Image(
            painter = painterResource(R.drawable.cat_fab),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .height(40.dp)
                .width(40.dp),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun CatContent(navController: NavController?) {
    val catListViewModel = viewModel<CatListViewModel>()
    val catListState = catListViewModel.catList.collectAsState()
    CatList(list = catListState.value, navController)
}