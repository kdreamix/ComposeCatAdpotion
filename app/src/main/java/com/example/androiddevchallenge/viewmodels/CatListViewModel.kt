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
package com.example.androiddevchallenge.viewmodels

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Abyssinian
import com.example.androiddevchallenge.models.Aegean
import com.example.androiddevchallenge.models.AmericanBobtail
import com.example.androiddevchallenge.models.AmericanCurl
import com.example.androiddevchallenge.models.CatModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CatListViewModel : ViewModel() {
    private val value = listOf(
        CatModel(
            id = "1",
            catName = "Bobby",
            catBreed = Abyssinian,
            catImage = R.drawable.img_abyssinian
        ),
        CatModel(id = "2", catName = "Alice", catBreed = Aegean, catImage = R.drawable.img_aegean),
        CatModel(
            id = "3",
            catName = "Kitty",
            catBreed = AmericanBobtail,
            catImage = R.drawable.img_american_bobtail
        ),
        CatModel(
            id = "4",
            catName = "Jenny",
            catBreed = AmericanCurl,
            catImage = R.drawable.img_american_curl
        ),
        CatModel(
            id = "5",
            catName = "Bobby",
            catBreed = Abyssinian,
            catImage = R.drawable.img_abyssinian
        ),
        CatModel(id = "6", catName = "Alice", catBreed = Aegean, catImage = R.drawable.img_aegean),
        CatModel(
            id = "7",
            catName = "Kitty",
            catBreed = AmericanBobtail,
            catImage = R.drawable.img_american_bobtail
        ),
        CatModel(
            id = "8",
            catName = "Jenny",
            catBreed = AmericanCurl,
            catImage = R.drawable.img_american_curl
        ),
        CatModel(
            id = "9",
            catName = "Bobby",
            catBreed = Abyssinian,
            catImage = R.drawable.img_abyssinian
        ),
        CatModel(id = "10", catName = "Alice", catBreed = Aegean, catImage = R.drawable.img_aegean),
        CatModel(
            id = "11",
            catName = "Kitty",
            catBreed = AmericanBobtail,
            catImage = R.drawable.img_american_bobtail
        ),
        CatModel(
            id = "12",
            catName = "Jenny",
            catBreed = AmericanCurl,
            catImage = R.drawable.img_american_curl
        ),

    )
    val catList: StateFlow<List<CatModel>> = MutableStateFlow(
        value
    )

    fun getCatById(id: String): CatModel? {
        return value.firstOrNull { it.id == id }
    }
}
