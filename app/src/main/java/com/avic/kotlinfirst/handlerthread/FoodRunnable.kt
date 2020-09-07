package com.avic.kotlinfirst.handlerthread

import java.util.*


class FoodRunnable(private var orderHandlerThread: OrderHandlerThread) : Runnable {

    private var thread: Thread = Thread(this)
    private var alive: Boolean = false
    private var count: Int = 0
    private var size:Int = 0


    override fun run() {
        alive = true
        while (alive && count < size){
            count++
            val foodName = getRandomOrderName()
            val foodPrice = getRandomOrderPrice()
            orderHandlerThread.sendOrder(FoodOrder(foodName, foodPrice))
            try{
                Thread.sleep(1000)
            }catch (exception: InterruptedException){
                exception.printStackTrace()
            }
        }
    }


    fun setMaxOrders(size: Int){
        this.size = size
    }

    fun start(){
        if (!thread.isAlive){
            thread.start()
        }
    }

    fun stop(){
        alive = false
    }

    private fun getRandomOrderName(): String{
        val random = Random()
        val randomOrder = random.nextInt(10)
        when (randomOrder) {
            0 ->
                return "McBurger"
            1 ->
                return "McCola"
            2 ->
                return "McPizza"
            3 ->
                return "McIceCream"
            4 ->
                return "McNoodles"
            5 ->
                return "McBeer"
            6 ->
                return "McLime"
            7 ->
                return "McCoffee"
            8 ->
                return "McCake"
            9 ->
                return "McOrange"
            10 ->
                return "McFries"
        }
        return "McFood"
    }

    private fun getRandomOrderPrice(): Float {
        val random = Random()
        val randomOrder = random.nextInt(10)
        when (randomOrder) {
            0 ->
                return 5f
            1 ->
                return 10f
            2 ->
                return 15f
            3 ->
                return 20f
            4 ->
                return 25f
            5 ->
                return 30f
            6 ->
                return 35f
            7 ->
                return 40f
            8 ->
                return 45f
            9 ->
                return 50f
            10 ->
                return 55f
        }

        return 60f
    }




}


































