package com.zekibiyikli.baseslidetexts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.zekibiyikli.slidetexts.SlideTexts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var layout=findViewById<ConstraintLayout>(R.id.lytSlideTexts)

        var slideTexts=SlideTexts()
        var strings= arrayListOf("Title 1","Title 2","Title 3","Title 4","Title 5")
        slideTexts.init(this,strings,layout)
        slideTexts.setColor(
            selectColor = R.color.selectcolor,
            unselectColor = R.color.unselectcolor)
        slideTexts.setTextSize(
            selectSize = 25f,
            unselectSize = 20f)
        slideTexts.setMillis(1000)
        slideTexts.start()
    }
}