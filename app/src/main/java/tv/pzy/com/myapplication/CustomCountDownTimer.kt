package tv.pzy.com.myapplication

import android.os.Handler


class CustomCountDownTimer : Runnable {
    override fun run() {
        if (isRun) {
            countDownHandler.onTimer(countDownTime)

            if (countDownTime == 0){
                countDownHandler.finish()
            }else{
                countDownTime = time--
                handler.postDelayed(this,1000)
            }
        }
    }
//    1、实时去回调 这个时间是多少  倒计时到几秒
//    2、支持动态传入总时间
//    3、没过一秒 总秒数 -1
//    4、总时间到零时,要回调完成状态

    var time: Int
    var countDownTime: Int
    lateinit var countDownHandler: ICountDownHandler
    private var handler: Handler = Handler()
    var isRun: Boolean = false

    public interface ICountDownHandler {
        open fun onTimer(time: Int)
        open fun finish()
    }

    constructor(time: Int, countDownHandler: ICountDownHandler?) {
        this.time = time
        if (countDownHandler != null)
            this.countDownHandler = countDownHandler
//        handler = object : Handler()   // 匿名内部类
        this.countDownTime = time
    }

    /*
    开启倒计时
     */
    fun start(){
        isRun = true
        handler.post(this)
    }

    /*
    取消倒计时
     */
    fun cancel(){
        isRun = false
        handler.removeCallbacks(this)
    }
}

