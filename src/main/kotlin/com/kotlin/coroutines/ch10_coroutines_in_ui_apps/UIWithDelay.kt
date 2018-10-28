package com.kotlin.coroutines.ch10_coroutines_in_ui_apps

//import javafx.beans.property.SimpleIntegerProperty
//import javafx.geometry.Pos
//import javafx.scene.layout.BorderPane
//import javafx.stage.Stage
//import kotlinx.coroutines.experimental.Job
//import kotlinx.coroutines.experimental.delay
//import kotlinx.coroutines.experimental.launch
//import tornadofx.*
//import kotlinx.coroutines.experimental.javafx.JavaFx as UI
//
//fun main(args: Array<String>) = launch<CoroutineApp>(args)
//
//
//class CoroutineApp : App(IntroView::class) {
//    override fun start(stage: Stage) {
//        stage.width = 200.0
//        stage.height = 400.0
//        super.start(stage)
//    }
//}
//
//class IntroView : View() {
//    override val root = BorderPane()
//    val counter = SimpleIntegerProperty()
//    lateinit var counterJob: Job
//
//    init {
//        title = "Counter"
//
//        with(root) {
//            style {
//                padding = box(20.px)
//            }
//
//            center {
//                vbox(10.0) {
//                    alignment = Pos.CENTER
//
//                    label() {
//                        bind(counter)
//                        style { fontSize = 25.px }
//                    }
//
//                    button("Click to increment") {
//
//                    }.setOnAction {
//                        // 2. add launch coroutine
//                        counterJob = launch(UI) {increment()}
//                    }
//                    button("Click to cancel") {
//
//                    }.setOnAction {
//                        // 2. add launch coroutine
//                        counterJob.cancel()
//                    }
//                }
//            }
//        }
//    }
//
//    fun oldincrement() {
//        Thread.sleep(3000)
//        launch(UI) {
//            counter.value += 1
//        }
//    }
//    suspend fun increment() {
//        delay(3000)
//
//        counter.value += 1
//
//    }
//}
