package com.example.easywords

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.graphics.Typeface
import android.view.View
import android.widget.*
import org.json.JSONArray
import kotlin.random.Random

data class Word(val nl: String, val en: String)

class MainActivity : Activity() {
    private lateinit var content: LinearLayout
    private val words = mutableListOf<Word>()
    private var quizIndex = 0
    private var quizScore = 0
    private var flashIndex = 0
    private var showingAnswer = false
    private val prefs by lazy { getSharedPreferences("progress", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content = findViewById(R.id.content)
        loadWords()
        findViewById<Button>(R.id.navHome).setOnClickListener { home() }
        findViewById<Button>(R.id.navStudy).setOnClickListener { study() }
        findViewById<Button>(R.id.navQuiz).setOnClickListener { startQuiz() }
        home()
    }

    private fun loadWords() {
        val text = assets.open("words.json").bufferedReader().use { it.readText() }
        val array = JSONArray(text)
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            words.add(Word(obj.getString("nl"), obj.getString("en")))
        }
    }

    private fun title(text: String) {
        content.removeAllViews()
        tv(text, 24, true)
        spacer(8)
    }

    private fun tv(text: String, size: Int = 16, bold: Boolean = false): TextView {
        val view = TextView(this)
        view.text = text
        view.textSize = size.toFloat()
        view.setTextColor(getColor(R.color.ink))
        if (bold) view.setTypeface(null, Typeface.BOLD)
        view.setPadding(4, 8, 4, 8)
        content.addView(view)
        return view
    }

    private fun btn(text: String, action: () -> Unit): Button {
        val button = Button(this)
        button.text = text
        button.setOnClickListener { action() }
        content.addView(button)
        return button
    }

    private fun spacer(height: Int) {
        val view = Space(this)
        view.minimumHeight = (height * resources.displayMetrics.density).toInt()
        content.addView(view)
    }

    private fun home() {
        title("Easy Words 🇳🇱")
        tv("Dutch → English", 18)
        tv("${words.size} words from your Easy Words list", 15)
        spacer(8)
        btn("📖  Learn words") { study() }
        btn("🃏  Flashcards") { flashcards() }
        btn("🧠  Start quiz") { startQuiz() }
        spacer(12)
        tv("Progress", 19, true)
        tv("Quiz correct: ${prefs.getInt("correct", 0)}", 16)
        tv("Quiz answered: ${prefs.getInt("answered", 0)}", 16)
    }

    private fun study() {
        title("Study")
        val search = EditText(this)
        search.hint = "Search Dutch or English"
        search.setSingleLine(true)
        content.addView(search, 1)

        val list = LinearLayout(this)
        list.orientation = LinearLayout.VERTICAL
        content.addView(list)

        fun render() {
            list.removeAllViews()
            val query = search.text.toString().trim().lowercase()
            words.filter {
                query.isEmpty() ||
                    it.nl.lowercase().contains(query) ||
                    it.en.lowercase().contains(query)
            }.take(100).forEach { word ->
                val item = TextView(this)
                item.text = "${word.nl}
${word.en}"
                item.textSize = 17f
                item.setTextColor(getColor(R.color.ink))
                item.setPadding(12, 12, 12, 12)
                list.addView(item)
            }
        }

        search.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = render()
            override fun afterTextChanged(s: android.text.Editable?) = Unit
        })
        render()
    }

    private fun flashcards() {
        flashIndex = Random.nextInt(words.size)
        showingAnswer = false
        renderFlash()
    }

    private fun renderFlash() {
        title("Flashcards")
        val word = words[flashIndex]
        tv(word.nl, 34, true)
        spacer(20)
        if (showingAnswer) {
            tv(word.en, 26)
        } else {
            tv("Tap Reveal to see the English meaning", 17)
        }
        spacer(20)
        if (!showingAnswer) {
            btn("Reveal") {
                showingAnswer = true
                renderFlash()
            }
        } else {
            btn("Next card") {
                flashIndex = Random.nextInt(words.size)
                showingAnswer = false
                renderFlash()
            }
        }
        btn("Back to home") { home() }
    }

    private fun startQuiz() {
        quizIndex = 0
        quizScore = 0
        nextQuestion()
    }

    private fun nextQuestion() {
        if (quizIndex >= 10) {
            title("Quiz complete 🎉")
            tv("Score: $quizScore / 10", 28, true)
            tv("Keep practising and try again.", 17)
            btn("Try again") { startQuiz() }
            btn("Home") { home() }
            return
        }

        title("Quiz ${quizIndex + 1} / 10")
        val word = words[Random.nextInt(words.size)]
        val options = mutableListOf(word.en)
        while (options.size < 4) {
            val candidate = words[Random.nextInt(words.size)].en
            if (!options.contains(candidate)) options.add(candidate)
        }
        options.shuffle()

        tv("What does this mean?", 17)
        tv(word.nl, 34, true)

        options.forEach { option ->
            btn(option) {
                val correct = option == word.en
                prefs.edit()
                    .putInt("answered", prefs.getInt("answered", 0) + 1)
                    .putInt("correct", prefs.getInt("correct", 0) + if (correct) 1 else 0)
                    .apply()
                if (correct) quizScore++
                quizIndex++
                val message = if (correct) "Correct!" else "Answer: ${word.en}"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                nextQuestion()
            }
        }
    }
}
