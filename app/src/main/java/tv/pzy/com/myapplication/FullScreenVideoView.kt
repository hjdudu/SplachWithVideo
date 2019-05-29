package tv.pzy.com.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.VideoView


/**
 * 全屏videoView
 */
class FullScreenVideoView :VideoView {

    constructor(context:Context) : super(context) {

    }
    constructor(context:Context,attrs:AttributeSet) : super(context,attrs) {

    }

    constructor(context:Context,attrs:AttributeSet,defStyleAttr:Int) : super(context,attrs,defStyleAttr) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        /*
        widthMeasureSpec,heightMeasureSpec 包含两个主要内容  1、測量模式  2、大小
         */
        var width = getDefaultSize(0,widthMeasureSpec)
        var height = View.getDefaultSize(0,heightMeasureSpec)
        setMeasuredDimension(width,height)
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}