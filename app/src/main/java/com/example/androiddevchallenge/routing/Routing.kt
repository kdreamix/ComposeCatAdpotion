package com.example.androiddevchallenge.routing

sealed class Routing(val id: String){
    companion object {
        const val PARAM_CAT_ID = "catId"
    }
}

object RouteCatList: Routing("list")
object RouteCatDetail: Routing("detail/{$PARAM_CAT_ID}")

