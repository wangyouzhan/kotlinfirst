package com.avic.kotlinfirst.handlerthread

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import java.util.*

class OrderHandlerThread(private var uiHandler: HanderThreadActivity.UiHandler) : HandlerThread("OrderHandlerThread") {

    private var handler: Handler? = null
    private var random: Random = Random()


    override fun onLooperPrepared() {
        super.onLooperPrepared()
        handler = getHandler(looper)
    }

    fun sendOrder(foodOrder: FoodOrder){
        val message = Message()
        message.obj = foodOrder
        handler?.sendMessage(message)
    }

    private fun getHandler(looper: Looper): Handler{
        return object : Handler(looper){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                val foodOrder = msg.obj as FoodOrder
                foodOrder.foodPrice = convertCurrency(foodOrder.foodPrice)
                val processedMessage = Message()
                processedMessage.obj = foodOrder
                uiHandler.sendMessage(processedMessage)
            }
        }
    }


    private fun convertCurrency(foodPriceInDollars: Float) : Float{
        return foodPriceInDollars * 68.45f
    }





    
}


































