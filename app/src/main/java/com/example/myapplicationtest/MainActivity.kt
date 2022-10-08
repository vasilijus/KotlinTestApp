package com.example.myapplicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var gameStarted = false
    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown: Long = 60000
    private var countDownInterval: Long = 1000
    private var timeLeft = 60

    private lateinit var gameScoreTextView: TextView
    private lateinit var timeLeftTextView: TextView
    private lateinit var tapMeButton: Button
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameScoreTextView = findViewById(R.id.game_score_text_view)
        timeLeftTextView = findViewById(R.id.timeleft_text_view)
        tapMeButton = findViewById(R.id.tap_me_button)

        tapMeButton.setOnClickListener {
            incrementScore()
        }

        resetGame()
    }

    private fun incrementScore() {
    // increment score logic
        if(!gameStarted) {
            startGame()
        }
        score++

        var newScore = getString(R.string.your_score, score)
        gameScoreTextView.text = newScore
    }
    private fun resetGame() {
    // reset game logic
        score = 0
        val initialScore = getString(R.string.your_score, score)
        gameScoreTextView.text = initialScore

        val initialTimeLeft = getString(R.string.time_left, 60)
        timeLeftTextView.text = initialTimeLeft

        countDownTimer = object: CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUnitlFinished: Long) {
                TODO("Not yet implemented")
                timeLeft = millisUnitlFinished.toInt() / 1000

                val timeLeftString = getString(R.string.time_left, timeLeft)
            }

            override fun onFinish() {
                TODO("Not yet implemented")

            }
        }

        gameStarted = false
    }
    private fun startGame() {
    // start game logic
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {
    //
    }
}