package com.example.easywords

import android.os.Bundle
import android.widget.*
import android.graphics.Typeface
import android.view.View
import android.content.Context
import org.json.JSONArray
import kotlin.random.Random

data class Word(val nl:String,val en:String)

class MainActivity: android.app.Activity() {
    private lateinit var content: LinearLayout
    private val words=mutableListOf<Word>()
    private var quizIndex=0
    private var quizScore=0
    private var flashIndex=0
    private var showingAnswer=false
    private val prefs by lazy { getSharedPreferences("progress",Context.MODE_PRIVATE) }

    override fun onCreate(b:Bundle?) { super.onCreate(b); setContentView(R.layout.activity_main); content=findViewById(R.id.content); loadWords();
        findViewById<Button>(R.id.navHome).setOnClickListener{home()}; findViewById<Button>(R.id.navStudy).setOnClickListener{study()}; findViewById<Button>(R.id.navQuiz).setOnClickListener{startQuiz()}; home() }

    private fun loadWords(){ val s=assets.open("words.json").bufferedReader().readText(); val a=JSONArray(s); for(i in 0 until a.length()){val o=a.getJSONObject(i); words.add(Word(o.getString("nl"),o.getString("en")))} }
    private fun title(t:String){content.removeAllViews(); tv(t,24,true); spacer(8)}
    private fun tv(s:String,size:Int=16,bold:Boolean=false):TextView{val v=TextView(this);v.text=s;v.textSize=size.toFloat();v.setTextColor(getColor(R.color.ink));if(bold)v.setTypeface(null,Typeface.BOLD);v.setPadding(4,8,4,8);content.addView(v);return v}
    private fun btn(s:String,action:()->Unit):Button{val b=Button(this);b.text=s;b.setOnClickListener{action()};content.addView(b);return b}
    private fun spacer(h:Int){val v=Space(this);v.minimumHeight=(h*resources.displayMetrics.density).toInt();content.addView(v)}
    private fun home(){title("Easy Words 🇳🇱");tv("Dutch → English",18);tv("${words.size} words from your Easy Words list",15);spacer(8);btn("📖  Learn words"){study()};btn("🃏  Flashcards"){flashcards()};btn("🧠  Start quiz"){startQuiz()};spacer(12);tv("Progress",19,true);tv("Quiz correct: ${prefs.getInt("correct",0)}",16);tv("Quiz answered: ${prefs.getInt("answered",0)}",16)}
    private fun study(){title("Study");val search=EditText(this);search.hint="Search Dutch or English";search.setSingleLine(true);content.addView(search,1);val list=LinearLayout(this);list.orientation=LinearLayout.VERTICAL;content.addView(list);fun render(){list.removeAllViews();val q=search.text.toString().trim().lowercase();words.filter{q.isEmpty()||it.nl.lowercase().contains(q)||it.en.lowercase().contains(q)}.take(100).forEach{val x=TextView(this);x.text="${it.nl}\n${it.en}";x.textSize=17f;x.setTextColor(getColor(R.color.ink));x.setPadding(12,12,12,12);list.addView(x);}};search.addTextChangedListener(object:android.text.TextWatcher{override fun beforeTextChanged(s:CharSequence?,st:Int,c:Int,a:Int){};override fun onTextChanged(s:CharSequence?,st:Int,b:Int,c:Int){render()};override fun afterTextChanged(e:android.text.Editable?){}});render()}
    private fun flashcards(){flashIndex=Random.nextInt(words.size);showingAnswer=false;renderFlash()}
    private fun renderFlash(){title("Flashcards");val w=words[flashIndex];tv(w.nl,34,true);spacer(20);if(showingAnswer)tv(w.en,26);else tv("Tap Reveal to see the English meaning",17);spacer(20);if(!showingAnswer)btn("Reveal"){showingAnswer=true;renderFlash()} else btn("Next card"){flashIndex=Random.nextInt(words.size);showingAnswer=false;renderFlash()};btn("Back to home"){home()}}
    private fun startQuiz(){quizIndex=0;quizScore=0;nextQuestion()}
    private fun nextQuestion(){if(quizIndex>=10){title("Quiz complete 🎉");tv("Score: $quizScore / 10",28,true);tv("Keep practising and try again.",17);btn("Try again"){startQuiz()};btn("Home"){home()};return};title("Quiz ${quizIndex+1} / 10");val w=words[Random.nextInt(words.size)];val options=mutableListOf(w.en);while(options.size<4){val x=words[Random.nextInt(words.size)].en;if(!options.contains(x))options.add(x)};options.shuffle();tv("What does this mean?",17);tv(w.nl,34,true);options.forEach{o->btn(o){val correct=o==w.en;prefs.edit().putInt("answered",prefs.getInt("answered",0)+1).putInt("correct",prefs.getInt("correct",0)+(if(correct)1 else 0)).apply();if(correct)quizScore++;quizIndex++;Toast.makeText(this,if(correct)"Correct!" else "Answer: ${w.en}",Toast.LENGTH_SHORT).show();nextQuestion()}})}
}
