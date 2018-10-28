package com.kotlin.coroutines.ch10_coroutines_in_ui_apps

//import javafx.collections.ObservableList
//import javafx.geometry.Pos
//import javafx.scene.layout.BorderPane
//import javafx.stage.Stage
//import kotlinx.coroutines.experimental.delay
//import kotlinx.coroutines.experimental.launch
//import tornadofx.*
//import kotlin.concurrent.thread
//import kotlinx.coroutines.experimental.javafx.JavaFx as UI
//
//fun main(args: Array<String>) = launch<ListReposApp>(args)
//
//
//class ListReposApp : App(IntroView::class) {
//    override fun start(stage: Stage) {
//        stage.width = 600.0
//        stage.height = 400.0
//        super.start(stage)
//    }
//}
//
//class IntroView : View() {
//    override val root = BorderPane()
//    private val api: Rest by inject()
//    private var repos = mutableListOf<Repo>().observable()
//
//    init {
//        api.baseURI = "https://api.github.com/"
//        title = "List of Repositories"
//
//        with(root) {
//
//            style {
//                padding = box(20.px)
//            }
//
//            center {
//
//                vbox(10.0) {
//                    alignment = Pos.CENTER
//
//                    button("Click to get") {
//
//                    }.setOnAction {
//                        // 2. add launch coroutine
//
//                        launch(UI) {
//                            getPublicRepos()
//                        }
//                    }
//
//                    tableview(repos) {
//                        column("ID", Repo::id)
//                        column("Name", Repo::name)
//                        column("Url", Repo::htmlUrl)
//                    }
//                }
//            }
//        }
//    }
//
//    private suspend fun getPublicRepos() {
//        // 1. add delay
//
//        //launch {
//        delay(2000)
//        val newrepos = getRepositories()
//        repos.removeAll()
//        repos.addAll(newrepos)
//        //}
//    }
//
//    private fun getRepositories(): ObservableList<Repo> =
//            api.get("users/kevinrjones/repos").list().toModel()
//}
//
