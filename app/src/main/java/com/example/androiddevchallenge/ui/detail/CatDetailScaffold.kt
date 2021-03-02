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
package com.example.androiddevchallenge.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BrightYellow
import com.example.androiddevchallenge.ui.theme.DarkBlack
import com.example.androiddevchallenge.viewmodels.CatListViewModel
import kotlinx.coroutines.launch

@Composable
fun CatDetailScaffold(catId: String = "", navController: NavController) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(DrawerValue.Closed)
    )
    val fabShape = CutCornerShape(16.dp)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { CatDetailTopBar(catId, navController) },
        snackbarHost = { state -> CatDetailSnackBarHost(state) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            CatDetailFloatingActionButton(
                scaffoldState,
                fabShape
            )
        },
        content = { CatDetailContent(catId) },
    )
}

@Composable
fun CatDetailTopBar(catId: String, navController: NavController) {
    val catListViewModel = viewModel<CatListViewModel>()
    val cat = catListViewModel.getCatById(catId)

    TopAppBar(
        title = { Text(cat!!.catName, color = DarkBlack) },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = DarkBlack
                )
            }
        },
        elevation = 0.dp
    )
}

@Composable
fun CatDetailSnackBarHost(state: SnackbarHostState) {
    SnackbarHost(
        state,
        snackbar = { data ->
            Snackbar(
                data,
            )
        }
    )
}

@Composable
fun CatDetailFloatingActionButton(scaffoldState: ScaffoldState, fabShape: CutCornerShape) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(
        shape = fabShape,
        onClick = {
            scope.launch {
                when (
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Meow",
                    )
                ) {
                    SnackbarResult.Dismissed -> Log.d("Track", "Dismissed")
                    SnackbarResult.ActionPerformed -> Log.d("Track", "Action!")
                }
            }
        },
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
fun CatDetailContent(catId: String) {
    val catListViewModel = viewModel<CatListViewModel>()
    val cat = catListViewModel.getCatById(catId)
    Log.v("CatDetailContent", catId)
    Log.v("CatDetailContent", cat.toString())
    CatDetail(catModel = cat!!)
}
