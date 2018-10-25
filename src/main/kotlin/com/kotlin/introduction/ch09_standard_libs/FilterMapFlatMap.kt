package com.kotlin.introduction.ch09_standard_libs

data class Album(val title: String, val year: Int, val chartUK: Int, val chartUS: Int, val tracks: List<Track> = listOf())
data class Track(val title: String, val durationInSeconds: Int)

val albums = listOf(
        Album("The Dark Side of the Moon", 1973, 2, 1,
                listOf(Track("Speak to Me", 90),
                        Track("Breathe", 163),
                        Track("On the Run", 216),
                        Track("Time", 412),
                        Track("The Great Gig in the Sky", 276),
                        Track("Money", 382),
                        Track("Us and Them", 462),
                        Track("Any Color You Like", 205),
                        Track("Brain Damage", 228),
                        Track("Eclipse", 123)
                )),
        Album("The Wall", 1979, 3, 1),
        Album("Wish You Where Here", 1975, 1, 1),
        Album("Animals", 1977, 2, 3),
        Album("The Piper at the Gates of Dawn", 1967, 6, 131),
        Album("The Final Cut", 1983, 1, 6),
        Album("Meddle", 1971, 3, 70),
        Album("Atom Heart Mother", 1970, 1, 55),
        Album("Ummagumma", 1969, 5, 74),
        Album("A Sauceful of Secrets", 1968, 9, 0),
        Album("More", 1969, 9, 153))

fun albumAndTrackLowerThanXSeconds(durationInSeconds: Int, albums: List<Album>): List<Pair<String, String>> {

    // map
    // [a, b, c] f(x) => [f(a), f(b), f(c)]
    // flatMap
    // [[a, b], [c, d] f(x) => [f(a), f(b), f(c), f(d)]
    return albums.flatMap {
        val album = it.title
        it.tracks.filter {
            it.durationInSeconds < durationInSeconds
        }.map {
            Pair(album, it.title)
        }
    }
}
fun main(args: Array<String>) {
    albums.forEach {
//        if (it.chartUK == 1) println("Found it - ${it.title}")
        album ->
        if (album.chartUK == 1) println("Found it - ${album.title}")
    }

    val albums1 = albums
    albums1.filter { it.chartUK == 1 }

    albums1.forEach { println("Found it ... ${it.title}") }

    albums.filter { it.chartUK == 1 }
            .forEach { println("Found it ... ${it.title}") }

    albums.filter { it.chartUK == 1 }
            .forEach {
                val titles = mutableListOf<String>()
                titles.add(it.title)
            }

    val titles = albums.filter { it.chartUK == 1 }
            .map { it.title }

    titles.forEach { println(it) }

    val titles2 = albums.filter { it.chartUK == 1 }
            .map { Pair(it.title, it.year) }

    titles2.forEach { println(it) }

    albumAndTrackLowerThanXSeconds(200, albums).forEach {
        println(it.first)
    }


}