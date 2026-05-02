package com.example.codealpha_flashcardapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var flashcardText: TextView
    private lateinit var flipButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button

    private val flashcards = listOf(
        Pair("What is the capital of France?", "Paris"),
        Pair("What is 5 + 7?", "12"),
        Pair("Who developed Android?", "Google"),
        Pair("What language is used for Android development?", "Kotlin"),
        Pair("What does XML stand for?", "eXtensible Markup Language")
    )

    private var currentIndex = 0
    private var showingQuestion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashcardText = findViewById(R.id.flashcardText)
        flipButton = findViewById(R.id.flipButton)
        nextButton = findViewById(R.id.nextButton)
        prevButton = findViewById(R.id.prevButton)

        updateFlashcard()

        flipButton.setOnClickListener {
            showingQuestion = !showingQuestion
            updateFlashcard()
        }

        nextButton.setOnClickListener {
            if (currentIndex < flashcards.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0
            }
            showingQuestion = true
            updateFlashcard()
        }

        prevButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
            } else {
                currentIndex = flashcards.size - 1
            }
            showingQuestion = true
            updateFlashcard()
        }
    }

    private fun updateFlashcard() {
        val (question, answer) = flashcards[currentIndex]
        flashcardText.text = if (showingQuestion) question else answer
    }
}
