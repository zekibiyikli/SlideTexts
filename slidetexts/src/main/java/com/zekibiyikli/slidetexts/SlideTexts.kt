package com.zekibiyikli.slidetexts

import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat
import java.lang.Exception

class SlideTexts {

    private lateinit var listText:ArrayList<String>
    private lateinit var listTv:ArrayList<TextView>
    private lateinit var listGL:ArrayList<Guideline>
    private lateinit var activity:Activity
    private lateinit var layout:ConstraintLayout
    private var lastIndex=0
    private lateinit var countDownTimer:CountDownTimer

    private var selectColor=R.color.selectcolor
    private var unselectColor=R.color.unselectcolor
    private var selectSize=18f
    private var unselectSize=16f
    private var typeFace:Typeface?=null
    private var millis:Long=3000

    fun init(activity:Activity,listText:ArrayList<String>,layout: ConstraintLayout){
        this.listText=listText
        this.activity=activity
        this.layout=layout
        initTv()
        initGl()
        firstInitText()
        startCountDownTimer()
    }

    fun start(){
        countDownTimer.start()
    }

    fun stop(){
        countDownTimer.cancel()
    }

    private fun initTv(){
        var tv1=activity.findViewById<TextView>(R.id.tv1)
        var tv2=activity.findViewById<TextView>(R.id.tv2)
        var tv3=activity.findViewById<TextView>(R.id.tv3)
        var tv4=activity.findViewById<TextView>(R.id.tv4)
        var tv5=activity.findViewById<TextView>(R.id.tv5)
        var basetv= arrayListOf(tv1,tv2,tv3,tv4,tv5)
        listTv=basetv
    }

    private fun initGl(){
        var gl1=activity.findViewById<Guideline>(R.id.gl1)
        var gl2=activity.findViewById<Guideline>(R.id.gl2)
        var gl3=activity.findViewById<Guideline>(R.id.gl3)
        var gl4=activity.findViewById<Guideline>(R.id.gl4)
        var gl5=activity.findViewById<Guideline>(R.id.gl5)
        var basegl= arrayListOf(gl1,gl2,gl3,gl4,gl5)
        listGL=basegl
    }

    private fun setSlide(){
        changeText()
        changeTextColor()
        changeTextSize()
        listTv[0].visibility= View.INVISIBLE
        listTv[1].visibility= View.VISIBLE
        listTv[2].visibility= View.VISIBLE
        listTv[3].visibility= View.VISIBLE
        listTv[4].visibility= View.VISIBLE
        valueAnimator(listGL[0],0)
        valueAnimator(listGL[1],1)
        valueAnimator(listGL[2],2)
        valueAnimator(listGL[3],3)
        valueAnimator(listGL[4],4)
        var newList= arrayListOf(listTv[1],listTv[2],listTv[3],listTv[4],listTv[0])
        var newListGL= arrayListOf(listGL[1],listGL[2],listGL[3],listGL[4],listGL[0])
        listTv=newList
        listGL=newListGL
    }

    private fun firstColorChange(){
        listTv[0].setTextColor(ContextCompat.getColor(activity, unselectColor))
        listTv[1].setTextColor(ContextCompat.getColor(activity, unselectColor))
        listTv[2].setTextColor(ContextCompat.getColor(activity, selectColor))
        listTv[3].setTextColor(ContextCompat.getColor(activity, unselectColor))
        listTv[4].setTextColor(ContextCompat.getColor(activity, unselectColor))
        listTv[0].typeface
    }
    private fun firstSizeChange(){
        listTv[0].setTextSize(unselectSize)
        listTv[1].setTextSize(unselectSize)
        listTv[2].setTextSize(selectSize)
        listTv[3].setTextSize(unselectSize)
        listTv[4].setTextSize(unselectSize)
    }
    private fun firstFontChange(){
        for (item in listTv){
            item.typeface=typeFace
        }
    }

    private fun changeTextColor(){
        listTv[2].setTextColor(ContextCompat.getColor(activity, unselectColor))
        listTv[3].setTextColor(ContextCompat.getColor(activity, selectColor))
    }

    private fun changeTextSize(){
        listTv[2].sizeScaleAnimation(selectSize,unselectSize)
        listTv[3].sizeScaleAnimation(unselectSize,selectSize)
    }

    private fun firstInitText(){
        try {
            listTv[1].text=listText[0]
            listTv[2].text=listText[1]
            listTv[3].text=listText[2]
            lastIndex=2
        }catch (e: Exception){
            listTv[1].text=""
            listTv[2].text=""
            listTv[3].text=""
        }
    }

    private fun changeText(){
        if (lastIndex==listText.size-1){
            lastIndex=0
        }else{
            lastIndex++
        }
        listTv[4].text=listText[lastIndex]
    }

    private fun valueAnimator(gl:Guideline,index:Int){
        var base=0.1f
        var result=1f
        if (index==0){
            base=0.1f
            result=0.9f
        }else if(index==1){
            base=0.3f
            result=0.1f
        }else if(index==2){
            base=0.5f
            result=0.3f
        }else if(index==3){
            base=0.7f
            result=0.5f
        }else if(index==4){
            base=0.9f
            result=0.7f
        }
        val valueAnimator = ValueAnimator.ofFloat(base, result)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            gl.setGuidelinePercent(value)
        }
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = 300
        valueAnimator.start()
    }

    private fun TextView.sizeScaleAnimation(startSize:Float,endSize: Float) {
        val valueAnimator = ValueAnimator.ofFloat(startSize, endSize)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            this.textSize=value
        }
        valueAnimator.duration = 300
        valueAnimator.start()
    }

    private fun startCountDownTimer(){
        countDownTimer=object : CountDownTimer(60000, millis) {
                override fun onTick(millisUntilFinished: Long) {
                    setSlide()
                }

                override fun onFinish() {
                    start()
                }
            }
    }

    fun setColor(selectColor:Int?,unselectColor:Int?){
        selectColor?.let {
            this.selectColor=selectColor
        }
        unselectColor?.let {
            this.unselectColor=unselectColor
        }
        firstColorChange()
    }
    fun setTextSize(selectSize:Float?,unselectSize:Float?){
        selectSize?.let {
            this.selectSize=selectSize
        }
        unselectSize?.let {
            this.unselectSize=unselectSize
        }
        firstSizeChange()
    }
    fun setFont(typeface: Typeface){
        this.typeFace=typeFace
        firstFontChange()
    }
    fun setMillis(millis:Long){
        this.millis=millis
        startCountDownTimer()
    }
}