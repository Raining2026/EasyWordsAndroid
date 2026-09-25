package com.example.easywords

import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Word(val nl: String, val en: String)

class MainActivity : AppCompatActivity() {

    private val words = listOf(
        Word("de", "the"),
        Word("en", "and"),
        Word("een", "a"),
        Word("het", "it"),
        Word("in", "in"),
        Word("te", "too"),
        Word("ik", "I"),
        Word("hebben", "to have"),
        Word("hij", "he"),
        Word("niet", "not"),
        Word("op", "on"),
        Word("dat", "that"),
        Word("voor", "before"),
        Word("er", "there"),
        Word("je", "you"),
        Word("zullen", "shall"),
        Word("kunnen", "can/to be able to"),
        Word("haar", "her"),
        Word("of", "or"),
        Word("wat", "what"),
        Word("gaan", "to go"),
        Word("hem", "him"),
        Word("komen", "come"),
        Word("dan", "then"),
        Word("zo", "so"),
        Word("moeten", "should"),
        Word("mijn", "my"),
        Word("zij", "she"),
        Word("deze", "this"),
        Word("we", "we"),
        Word("meer", "more"),
        Word("dit", "this"),
        Word("maken", "to make"),
        Word("staan", "stand"),
        Word("goed", "good"),
        Word("ander", "other"),
        Word("doen", "to do"),
        Word("me", "me"),
        Word("u", "you"),
        Word("mij", "me"),
        Word("laten", "to let"),
        Word("al", "already"),
        Word("daar", "there"),
        Word("denken", "to think"),
        Word("toen", "then (past)"),
        Word("geven", "to give"),
        Word("hoe", "how"),
        Word("nu", "now"),
        Word("vinden", "find"),
        Word("man", "man"),
        Word("jaar", "year"),
        Word("hier", "here"),
        Word("wij", "we"),
        Word("houden", "to keep"),
        Word("zitten", "to sit"),
        Word("hand", "hand"),
        Word("lang", "long"),
        Word("twee", "two"),
        Word("dag", "day"),
        Word("eerst", "first"),
        Word("alleen", "only"),
        Word("brengen", "bring"),
        Word("beginnen", "to begin"),
        Word("zelf", "self"),
        Word("horen", "to hear"),
        Word("nieuw", "new"),
        Word("laat", "late"),
        Word("voelen", "to feel"),
        Word("plaats", "place"),
        Word("leven", "life"),
        Word("huis", "house"),
        Word("vallen", "fall"),
        Word("moeder", "mother"),
        Word("spreken", "to speak"),
        Word("woord", "word"),
        Word("ja", "yes"),
        Word("wanneer", "when"),
        Word("vader", "father"),
        Word("werk", "work"),
        Word("elk", "each"),
        Word("ver", "far"),
        Word("later", "later"),
        Word("vertellen", "to tell"),
        Word("jij", "you"),
        Word("drie", "three"),
        Word("oud", "old"),
        Word("soms", "sometimes"),
        Word("wereld", "world"),
        Word("uur", "hour"),
        Word("naam", "name"),
        Word("soort", "kind"),
        Word("werken", "to work"),
        Word("vol", "full"),
        Word("welk", "which"),
        Word("boek", "book"),
        Word("deur", "door"),
        Word("ding", "thing"),
        Word("nee", "no"),
        Word("water", "water"),
        Word("feit", "fact"),
        Word("wachten", "to wait"),
        Word("leren", "to learn"),
        Word("open", "open"),
        Word("probleem", "problem"),
        Word("groep", "group"),
        Word("jong", "young"),
        Word("wit", "white"),
        Word("zodat", "so that"),
        Word("lachen", "laugh"),
        Word("bed", "bed"),
        Word("verder", "further"),
        Word("moment", "moment"),
        Word("staat", "state"),
        Word("vriend", "friend"),
        Word("week", "week"),
        Word("laatste", "last"),
        Word("helpen", "to help"),
        Word("licht", "light"),
        Word("diep", "deep"),
        Word("nacht", "night"),
        Word("langs", "along"),
        Word("beide", "both"),
        Word("jullie", "you"),
        Word("vrij", "free"),
        Word("gevoel", "feeling"),
        Word("half", "half"),
        Word("tafel", "table"),
        Word("school", "school"),
        Word("vier", "four"),
        Word("dood", "death"),
        Word("sociaal", "social"),
        Word("hard", "hard"),
        Word("wijn", "wine"),
        Word("maand", "month"),
        Word("mond", "mouth"),
        Word("reden", "reason"),
        Word("voet", "foot"),
        Word("idee", "idea"),
        Word("rol", "role"),
        Word("jou", "you"),
        Word("antwoord", "answer"),
        Word("slapen", "to sleep"),
        Word("plan", "plan"),
        Word("meestal", "mostly"),
        Word("straat", "street"),
        Word("persoon", "person"),
        Word("schouder", "shoulder"),
        Word("luisteren", "listen"),
        Word("invloed", "influence"),
        Word("hart", "heart"),
        Word("zoon", "son"),
        Word("bezig", "busy"),
        Word("arm", "arm"),
        Word("tien", "ten"),
        Word("los", "loose"),
        Word("vijf", "five"),
        Word("minuut", "minute"),
        Word("liefde", "love"),
        Word("sommige", "some"),
        Word("direct", "directly"),
        Word("relatie", "relationship"),
        Word("systeem", "system"),
        Word("proces", "process"),
        Word("menen", "mean"),
        Word("derde", "third"),
        Word("drinken", "drink"),
        Word("contact", "contact"),
        Word("functie", "function"),
        Word("warm", "warm"),
        Word("vinger", "finger"),
        Word("kleur", "color"),
        Word("pijn", "pain"),
        Word("glas", "glass"),
        Word("artikel", "article"),
        Word("eind", "end"),
        Word("persoonlijk", "personally"),
        Word("rood", "red"),
        Word("dokter", "doctor"),
        Word("zee", "sea"),
        Word("groeien", "to grow"),
        Word("koud", "cold"),
        Word("leiden", "to lead"),
        Word("familie", "family"),
        Word("periode", "period"),
        Word("sinds", "since"),
        Word("resultaat", "result"),
        Word("normaal", "normal"),
        Word("rond", "round"),
        Word("organisatie", "organization"),
        Word("speciaal", "special"),
        Word("patiënt", "patient"),
        Word("broer", "brother"),
        Word("leveren", "to deliver"),
        Word("hopen", "to hope"),
        Word("totaal", "total"),
        Word("zes", "six"),
        Word("blauw", "blue"),
        Word("stap", "step"),
        Word("karakter", "character"),
        Word("theorie", "theory"),
        Word("bloed", "blood"),
        Word("beter", "better"),
        Word("dochter", "daughter"),
        Word("stappen", "to step"),
        Word("droom", "dream"),
        Word("meter", "meter"),
        Word("steen", "stone"),
        Word("hulp", "help"),
        Word("rest", "rest"),
        Word("muziek", "music"),
        Word("maaltijd", "meal"),
        Word("openen", "to open"),
        Word("bank", "bank"),
        Word("papier", "paper"),
        Word("hoop", "hope"),
        Word("minister", "minister"),
        Word("wind", "wind"),
        Word("koffie", "coffee"),
        Word("stoppen", "stop"),
        Word("oor", "ear"),
        Word("informatie", "information"),
        Word("methode", "method"),
        Word("lip", "lip"),
        Word("positie", "position"),
        Word("alle", "all"),
        Word("enorm", "enormous"),
        Word("foto", "photo"),
        Word("film", "movie"),
        Word("activiteit", "activity"),
        Word("modern", "modern"),
        Word("geluk", "luck"),
        Word("basis", "base"),
        Word("zuster", "sister"),
        Word("wakker", "awake"),
        Word("tante", "aunt"),
        Word("vuur", "fire"),
        Word("prijs", "price"),
        Word("reactie", "reaction"),
        Word("praktijk", "practice"),
        Word("neus", "nose"),
        Word("terrein", "terrain"),
        Word("koning", "king"),
        Word("zingen", "to sing"),
        Word("vliegen", "fly"),
        Word("cultuur", "culture"),
        Word("missen", "to miss"),
        Word("politie", "law enforcement"),
        Word("wensen", "to wish"),
        Word("factor", "factor"),
        Word("begin", "get started"),
        Word("succes", "good luck"),
        Word("kosten", "to cost"),
        Word("natuur", "nature"),
        Word("hotel", "hotel"),
        Word("studie", "study"),
        Word("vriendelijk", "friendly"),
        Word("aspect", "aspect"),
        Word("figuur", "figure"),
        Word("ontbreken", "lack"),
        Word("nationaal", "national"),
        Word("ziek", "sick"),
        Word("term", "term"),
        Word("geef", "give"),
        Word("rennen", "To run"),
        Word("Engels", "english"),
        Word("effect", "effect"),
        Word("plant", "plant"),
        Word("product", "product"),
        Word("slaap", "sleep"),
        Word("tekst", "text"),
        Word("knie", "knee"),
        Word("geboren", "born"),
        Word("telefoon", "phone"),
        Word("individueel", "individually"),
        Word("structuur", "structure"),
        Word("helft", "half"),
        Word("trein", "train"),
        Word("praktisch", "practical"),
        Word("zomer", "summer"),
        Word("winnen", "to win"),
        Word("conclusie", "conclusion"),
        Word("baby", "baby"),
        Word("internationaal", "international"),
        Word("eiland", "island"),
        Word("meester", "master"),
        Word("kwaliteit", "quality"),
        Word("vullen", "to fill"),
        Word("individu", "individual"),
        Word("vervullen", "fulfill"),
        Word("plaatsen", "place"),
        Word("bespreken", "discuss"),
        Word("discussie", "discussion"),
        Word("sigaret", "cigarette"),
        Word("vis", "fish"),
        Word("absoluut", "absolutely"),
        Word("historisch", "historical"),
        Word("nummer", "number"),
        Word("schaduw", "shadow"),
        Word("leiding", "leadership"),
        Word("kat", "cat"),
        Word("universiteit", "university"),
        Word("mezelf", "myself"),
        Word("fase", "phase"),
        Word("technisch", "technical"),
        Word("positief", "positive"),
        Word("programma", "program"),
        Word("leider", "leader"),
        Word("wapen", "weapon"),
        Word("literatuur", "literature"),
        Word("brood", "bread"),
        Word("medisch", "medical"),
        Word("officier", "officer"),
        Word("rivier", "river"),
        Word("dansen", "to dance"),
        Word("interessant", "interesting"),
        Word("markt", "market"),
        Word("officieel", "officially"),
        Word("baas", "boss"),
        Word("schoen", "shoe"),
        Word("boot", "boat"),
        Word("vloer", "floor"),
        Word("dromen", "to dream"),
        Word("winter", "winter"),
        Word("maan", "moon"),
        Word("kilometer", "kilometers"),
        Word("wens", "wish"),
        Word("miljoen", "million"),
        Word("seconde", "second"),
        Word("rijk", "rich"),
        Word("bier", "beer"),
        Word("collega", "colleague"),
        Word("actie", "action"),
        Word("plezier", "pleasure"),
        Word("psychologie", "psychology"),
        Word("techniek", "technic"),
        Word("vechten", "to fight"),
        Word("gras", "grass"),
        Word("pad", "path"),
        Word("financieel", "financial"),
        Word("beïnvloeden", "to influence"),
        Word("actief", "active"),
        Word("ster", "star"),
        Word("machine", "machine"),
        Word("energie", "energy"),
        Word("gouden", "golden"),
        Word("nek", "neck"),
        Word("rusten", "to rest"),
        Word("auteur", "author"),
        Word("procent", "per cent"),
        Word("museum", "museum"),
        Word("realiseren", "realize"),
        Word("cultureel", "cultural"),
        Word("bus", "bus"),
        Word("directeur", "director"),
        Word("materiaal", "material"),
        Word("produceren", "to produce"),
        Word("veld", "field"),
        Word("gast", "guest"),
        Word("dubbel", "double"),
        Word("zand", "sand"),
        Word("centrum", "centre"),
        Word("productie", "production"),
        Word("westen", "west"),
        Word("specifiek", "specific"),
        Word("koel", "cool"),
        Word("wassen", "To wash"),
        Word("klant", "client"),
        Word("tong", "tongue"),
        Word("argument", "argument"),
        Word("negatief", "negative"),
        Word("kaas", "cheese"),
        Word("titel", "title"),
        Word("visie", "vision"),
        Word("persoonlijkheid", "personality"),
        Word("kust", "coast"),
        Word("danken", "to thank"),
        Word("radio", "radio"),
        Word("wijd", "wide"),
        Word("jezelf", "yourself"),
        Word("interesseren", "to be interested"),
        Word("olie", "oil"),
        Word("thee", "tea"),
        Word("risico", "risk"),
        Word("president", "president"),
        Word("groen", "green"),
        Word("honger", "hungry"),
        Word("traditioneel", "traditional"),
        Word("adres", "address"),
        Word("experiment", "experiment"),
        Word("fundamenteel", "fundamentally"),
        Word("advies", "advice"),
        Word("klimmen", "to climb"),
        Word("typisch", "typical"),
        Word("stijl", "style"),
        Word("top", "top"),
        Word("traditie", "tradition"),
        Word("heet", "hot"),
        Word("psychologisch", "psychological"),
        Word("computer", "computer"),
        Word("generatie", "generation"),
        Word("bodem", "bottom"),
        Word("student", "student"),
        Word("relatief", "relatively"),
        Word("categorie", "category"),
        Word("kalm", "calm"),
        Word("eindigen", "to end"),
        Word("goederen", "goods"),
        Word("formuleren", "to formulate"),
        Word("instrument", "instrument"),
        Word("klas", "class"),
        Word("combinatie", "combination"),
        Word("publiceren", "to publish"),
        Word("landschap", "landscape"),
        Word("warmte", "warmth"),
        Word("televisie", "television"),
        Word("organiseren", "to organize"),
        Word("patroon", "pattern"),
        Word("agent", "agent"),
        Word("emotie", "emotion"),
        Word("orgaan", "organ"),
        Word("provincie", "province"),
        Word("detail", "detail"),
        Word("restaurant", "restaurant"),
        Word("wild", "wild"),
        Word("pijnlijk", "painful"),
        Word("station", "station"),
        Word("klassiek", "classic"),
        Word("sector", "sector"),
        Word("eindeloos", "endless"),
        Word("emotioneel", "emotional"),
        Word("studeren", "to study"),
        Word("symbool", "symbol"),
        Word("luitenant", "lieutenant"),
        Word("passeren", "pass"),
        Word("motief", "motive"),
        Word("fabriek", "factory"),
        Word("lijst", "list"),
        Word("serieus", "serious"),
        Word("logisch", "logical"),
        Word("mama", "mom"),
        Word("vluchten", "to flee"),
        Word("noorden", "north"),
        Word("bijten", "to bite"),
        Word("vorming", "formation"),
        Word("café", "cafe"),
        Word("object", "object"),
        Word("Holland", "Holland"),
        Word("kamp", "camp"),
        Word("dun", "thin"),
        Word("ideaal", "ideal"),
        Word("juni", "june"),
        Word("accepteren", "to accept"),
        Word("initiatief", "initiative"),
        Word("bitter", "bitter"),
        Word("verspreiden", "to spread"),
        Word("verbieden", "to forbid"),
        Word("consequentie", "consequence"),
        Word("oktober", "October"),
        Word("westers", "western"),
        Word("jongeman", "young man"),
        Word("hoed", "hat"),
        Word("zenden", "to send"),
        Word("zondag", "sunday"),
        Word("theoretisch", "theoretically"),
        Word("psycholoog", "psychologist"),
        Word("pers", "press"),
        Word("terras", "terrace"),
        Word("dood", "dead"),
        Word("crisis", "crisis"),
        Word("pot", "pot"),
        Word("operatie", "operation"),
        Word("partner", "partner"),
        Word("suiker", "sugar"),
        Word("gemeen", "mean"),
        Word("plaat", "plate"),
        Word("stijf", "stiff"),
        Word("economie", "economy"),
        Word("bruin", "brown"),
        Word("sneeuw", "snow"),
        Word("kruis", "cross"),
        Word("automatisch", "automatically"),
        Word("project", "project"),
        Word("hut", "hut"),
        Word("fruit", "fruit"),
        Word("communicatie", "communication"),
        Word("dom", "dumb")
    )

    private var index = 0
    private var showingEnglish = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun baseLayout(): LinearLayout {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40, 48, 40, 40)
        layout.gravity = Gravity.CENTER_HORIZONTAL
        return layout
    }

    private fun addTitle(layout: LinearLayout, text: String) {
        val view = TextView(this)
        view.text = text
        view.textSize = 28f
        view.setTextColor(Color.BLACK)
        view.gravity = Gravity.CENTER
        layout.addView(
            view,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
    }

    private fun addButton(layout: LinearLayout, text: String, action: () -> Unit) {
        val button = Button(this)
        button.text = text
        button.textSize = 17f
        button.setOnClickListener { action() }

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 18, 0, 0)
        layout.addView(button, params)
    }

    private fun showHome() {
        val layout = baseLayout()
        addTitle(layout, "Easy Words")

        val count = TextView(this)
        count.text = "${words.size} Dutch-English words"
        count.textSize = 18f
        count.gravity = Gravity.CENTER
        layout.addView(count)

        addButton(layout, "Study") {
            index = 0
            showingEnglish = false
            showStudy()
        }

        addButton(layout, "Flashcards") {
            index = 0
            showingEnglish = false
            showFlashcard()
        }

        setContentView(layout)
    }

    private fun showStudy() {
        val layout = baseLayout()
        addTitle(layout, "Study")

        val word = words[index]

        val dutch = TextView(this)
        dutch.text = word.nl
        dutch.textSize = 36f
        dutch.gravity = Gravity.CENTER
        layout.addView(dutch)

        val english = TextView(this)
        english.text = word.en
        english.textSize = 24f
        english.gravity = Gravity.CENTER
        english.setPadding(0, 20, 0, 20)
        layout.addView(english)

        val position = TextView(this)
        position.text = "${index + 1} / ${words.size}"
        position.textSize = 16f
        position.gravity = Gravity.CENTER
        layout.addView(position)

        addButton(layout, "Next") {
            index = (index + 1) % words.size
            showStudy()
        }

        addButton(layout, "Home") {
            showHome()
        }

        setContentView(layout)
    }

    private fun showFlashcard() {
        val layout = baseLayout()
        addTitle(layout, "Flashcards")

        val card = TextView(this)
        card.text = if (showingEnglish) words[index].en else words[index].nl
        card.textSize = 34f
        card.gravity = Gravity.CENTER
        card.setPadding(20, 50, 20, 50)
        layout.addView(
            card,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                220
            )
        )

        addButton(layout, if (showingEnglish) "Show Dutch" else "Show English") {
            showingEnglish = !showingEnglish
            showFlashcard()
        }

        addButton(layout, "Next") {
            index = (index + 1) % words.size
            showingEnglish = false
            showFlashcard()
        }

        addButton(layout, "Home") {
            showHome()
        }

        setContentView(layout)
    }
}
