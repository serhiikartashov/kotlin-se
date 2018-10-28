package com.kotlin.coroutines.ch10_coroutines_in_ui_apps

//import javafx.beans.property.SimpleDoubleProperty
//import javafx.beans.property.SimpleIntegerProperty
//import javafx.geometry.Pos
//import javafx.scene.layout.BorderPane
//import javafx.stage.Stage
//import kotlinx.coroutines.experimental.*
//import tornadofx.*
//import kotlinx.coroutines.experimental.javafx.JavaFx as UI
//
//var actor: Job = Job()
//lateinit var response: CompletableDeferred<Double>
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
//    val pi = SimpleDoubleProperty()
//    lateinit var counterJob: Job
//
//    init {
//        title = "Pi"
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
//                        bind(pi)
//                        style { fontSize = 25.px }
//                    }
//
//                    button("Click to calculate") {
//
//                    }.setOnAction {
//                        // 2. add launch coroutine
//                        pi.value = 0.0
//                        launch(UI) { calculatePi() }
//                    }
//                    button("Click to cancel") {
//
//                    }.setOnAction {
//                        // 2. add launch coroutine
//                        launch(UI) { actor.cancel()
//                            response.completeExceptionally(CancellationException())
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    suspend fun calculatePi() {
//        response = CompletableDeferred<Double>()
//
//        try {
//            workerActor(CommonPool).send(Start(response, 4))
//            pi.value = response.await()
//        } catch(e: CancellationException) {
//            log("Cancelled")
//            actor = Job()
//        }
//    }
//}
