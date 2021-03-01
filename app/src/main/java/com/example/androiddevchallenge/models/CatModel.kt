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
package com.example.androiddevchallenge.models

import java.util.UUID

data class CatModel(
    val id: String = UUID.randomUUID().toString(),
    val catName: String,
    val catBreed: CatBreed?,
) {
    companion object {
        val defaultCat = CatModel(catName = "default", catBreed = null)
    }
}

sealed class CatBreed(
    val breedName: String,
    val origin: String,
    val breedType: String,
    val bodyType: String,
    val coatLength: String,
    val coatPattern: String,
    val imageRes: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CatBreed

        if (breedName != other.breedName) return false
        if (origin != other.origin) return false
        if (breedType != other.breedType) return false
        if (bodyType != other.bodyType) return false
        if (coatLength != other.coatLength) return false
        if (coatPattern != other.coatPattern) return false
        if (imageRes != other.imageRes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = breedName.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + breedType.hashCode()
        result = 31 * result + bodyType.hashCode()
        result = 31 * result + coatLength.hashCode()
        result = 31 * result + coatPattern.hashCode()
        result = 31 * result + imageRes
        return result
    }
}
