/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.list

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BrightYellow
import com.example.androiddevchallenge.ui.theme.DarkBlack
import com.example.androiddevchallenge.ui.theme.DarkYellow
import com.example.androiddevchallenge.ui.theme.typography
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
        snackbarHost = { state -> CatSnackBarHost(state) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = { CatFloatingActionButton(scaffoldState, fabShape) },
        content = { CatContent(navController) },
    )
}

@Preview("Cat top bar")
@Composable
fun CatTopBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Cat",
                    color = if (MaterialTheme.colors.isLight) {
                        DarkBlack
                    } else {
                        DarkYellow
                    },
                    style = typography.h5
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.cat_fab),
                    contentDescription = null,
                    tint = if (MaterialTheme.colors.isLight) {
                        DarkBlack
                    } else {
                        BrightYellow
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Adopt",
                    color = if (MaterialTheme.colors.isLight) {
                        DarkBlack
                    } else {
                        DarkYellow
                    },
                    style = typography.h5
                )
            }

        },
        Modifier

            .padding(16.dp),
        elevation = 0.dp
    )
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
        }
    )
}

@Composable
fun CatFloatingActionButton(scaffoldState: ScaffoldState, fabShape: CutCornerShape) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(
        shape = fabShape,
        onClick = {
            scope.launch {
                when (
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Snackbar",
                        actionLabel = "Ok"
                    )
                ) {
                    SnackbarResult.Dismissed -> Log.d("Track", "Dismissed")
                    SnackbarResult.ActionPerformed -> Log.d("Track", "Action!")
                }
            }
        }
    ) {
        Icon(
            painter = painterResource(R.drawable.cat_fab),
            contentDescription = null,
            tint = if (MaterialTheme.colors.isLight) {
                BrightYellow
            } else {
                DarkBlack
            },
            modifier = Modifier
                .padding(12.dp)
                .height(40.dp)
                .width(40.dp),
        )
    }
}

@Composable
fun CatContent(navController: NavController?) {
    val catListViewModel = viewModel<CatListViewModel>()
    val catListState = catListViewModel.catList.collectAsState()
    CatList(list = catListState.value, navController)
}
