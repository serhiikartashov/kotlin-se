package com.kotlin.advanced.ch03_classes

class DirectoryExplorer(val user: String) {
    // private
    class PermissionCheck() {
        fun validatePermission() {
        }
    }

    fun listFolder(folder: String, user: String) {
        val permissionCheck = PermissionCheck()
        permissionCheck.validatePermission()
    }
}

class DirectoryExplorer2(val user: String) {
    // private
    inner class PermissionCheck() {
        fun validatePermission() {
            // inner allow get access to user member
            if (user != "Serhii"){}
        }
    }

    fun listFolder(folder: String, user: String) {
        val permissionCheck = PermissionCheck()
        permissionCheck.validatePermission()
    }
}

fun main(args: Array<String>) {
    val de = DirectoryExplorer("Serhii")

    val pc1 = DirectoryExplorer.PermissionCheck()
    val pc2 = DirectoryExplorer2("Serhii").PermissionCheck()
}