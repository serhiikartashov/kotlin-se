kotlinc Main.kt
java com.kotlin.compile.MainKt

kotlinc Main.kt -d hello.jar

kotlinc Main.kt -include-runtime -d hello.jar

java -jar hello.jar