package day5

typealias Coordinate = Pair<Int,Int>
typealias Vents = Pair<Coordinate, Coordinate>


@JvmInline
value class ThermalMap(val lines : Collection<Vents>){
    init {

    }
}