package com.kotlin.advanced.ch03_classes;

public class NestedClasses {

    public static void main(String[] args) {
        DirectoryExplorer.PermissionCheck pc = new DirectoryExplorer.PermissionCheck();

//        Log log = Log.Factory.createFileLog("file.txt");
        Log log = Log.createFileLog("file.txt");

        // private constructor denies create constructor
//        Log logDirectory = Log();
    }
}
