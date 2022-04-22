package com.zekibiyikli.slidetexts

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class baseLayout:ConstraintLayout {

    constructor(context:Context) : super(context) {
        initialize(context)
    }

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        initialize(context)
    }

    @SuppressLint("ResourceType")
    fun initialize(context:Context){
        inflate(context,R.layout.baselayout,this)
    }
}