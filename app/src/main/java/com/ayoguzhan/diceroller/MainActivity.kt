package com.ayoguzhan.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var diceOne: ImageView = findViewById(R.id.diceOne)
        var diceSecond: ImageView = findViewById(R.id.diceSecond)
        var diceText: TextView = findViewById(R.id.diceText)
        var coinText: TextView = findViewById(R.id.coinText)
        var rollBut: Button = findViewById(R.id.rollBut)
        var diceBut: Button = findViewById(R.id.startBut)
        var restartBut: Button = findViewById(R.id.restartBut)

        var dice = 5
        var coin = 0

        coinText.isVisible = false
        restartBut.isVisible = false
        diceOne.isVisible= false
        diceSecond.isVisible = false
        diceText.isVisible= false
        rollBut.isVisible= false

        diceBut.setOnClickListener{
            diceBut.isVisible= false
            coinText.isVisible = true
            diceOne.isVisible= true
            diceSecond.isVisible = true
            diceText.isVisible= true
            rollBut.isVisible= true
            diceOne.setImageResource(R.drawable.dice_1)
            diceSecond.setImageResource(R.drawable.dice_3)
            Toast.makeText(this, "Oyuna Hoşgeldiniz!" +
                    "Toplam 5 hakkınız var.Göreviniz aynı sayılı zar getirmek ve altın kazanmak.", Toast.LENGTH_LONG).show()
        }

        restartBut.setOnClickListener {
            rollBut.isEnabled = true
            dice = 5
            diceText.text = "Dice: ${dice} "
            restartBut.isVisible = false
            coin = 0
            coinText.text = "Coin: ${coin}"
        }



        rollBut.setOnClickListener{

            dice -= 1
            diceText.text = "Dice: ${dice} "
            var randomOne = (1..6).random()
            var randomSecond = (1..6).random()

            when(randomOne){
                1->diceOne.setImageResource(R.drawable.dice_1)
                2->diceOne.setImageResource(R.drawable.dice_2)
                3->diceOne.setImageResource(R.drawable.dice_3)
                4->diceOne.setImageResource(R.drawable.dice_4)
                5->diceOne.setImageResource(R.drawable.dice_5)
                6->diceOne.setImageResource(R.drawable.dice_6)
            }
            when(randomSecond){
                1->diceSecond.setImageResource(R.drawable.dice_1)
                2->diceSecond.setImageResource(R.drawable.dice_2)
                3->diceSecond.setImageResource(R.drawable.dice_3)
                4->diceSecond.setImageResource(R.drawable.dice_4)
                5->diceSecond.setImageResource(R.drawable.dice_5)
                6->diceSecond.setImageResource(R.drawable.dice_6)
            }
            if(randomOne == randomSecond){
                Toast.makeText(this, "Tebrikler!!!Altın kazandınız ve hakkınız fullendi.", Toast.LENGTH_LONG).show()
                dice = 5
                coin +=1
                coinText.text = "Coin: ${coin} "
                diceText.text = "Dice: ${dice} "
            }
            if(dice == 0){
                Toast.makeText(this, "Hakkınız dolmuştur ve altın miktarınız sıfırlanmıştır.", Toast.LENGTH_SHORT).show()
                rollBut.isEnabled  =false
                restartBut.isVisible = true
            }



            

            
        }

    }
}