package gfg.simple



    fun minJump(arr: List<Int>): Int {

        var res = IntArray(arr.size)
        println(res)

        return res[0]
    }


    fun main() {
        val arr1 = listOf(1, 3, 6, 1, 0, 9)
        val arr2 = listOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)
        println("min jumps needed : " + minJump(arr1))
        println("min jumps needed : " + minJump(arr2))
    }


main()