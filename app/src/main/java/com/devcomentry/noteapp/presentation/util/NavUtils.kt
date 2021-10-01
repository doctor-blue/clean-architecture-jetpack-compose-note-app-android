package com.devcomentry.noteapp.presentation.util

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.devcomentry.noteapp.presentation.navigation.Param

open class ComposeScreen(val route: String){
    fun setParam(param: Param): String {
        var routeString = "$route?"
        val fields = param.javaClass.declaredFields
        for (field in fields) {
            field.isAccessible = true
            if (field.name != "\$stable")
                routeString += "${field.name}=${field.get(param)}&"
        }
        routeString = routeString.dropLast(1)
        return routeString
    }

    fun getRoute(param: Param): String {
        var routeString = "$route?"
        val fields = param.javaClass.declaredFields
        for (field in fields) {
            if (field.name != "\$stable")
                routeString += "${field.name}={${field.name}}&"
        }
        routeString = routeString.dropLast(1)
        return routeString
    }

    fun getNavArgs(param: Param): List<NamedNavArgument> {
        val fields = param.javaClass.declaredFields
        val args = mutableListOf<NamedNavArgument>()
        for (field in fields) {
            field.isAccessible = true
            if (field.name != "\$stable")
                args.add(
                    navArgument(field.name) {
                        type = NavType.inferFromValueType(field.get(param))
                    }
                )
        }
        return args
    }
}
