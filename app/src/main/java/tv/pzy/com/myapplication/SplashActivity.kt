package tv.pzy.com.myapplication

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    lateinit var timer: CustomCountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        vv_splash.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_splash));
        vv_splash.start()

        vv_splash.setOnCompletionListener(MediaPlayer.OnCompletionListener {
            vv_splash.start()
        })

//        tv_time.setText()

        timer = CustomCountDownTimer(5, object : CustomCountDownTimer.ICountDownHandler {
            override fun onTimer(time: Int) {
                tv_time.setText(time.toString() + "秒")   // kotlin 不支持直接 +
            }

            override fun finish() {
                tv_time.setText(R.string.jump)
            }
        })

        tv_time.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                /*
                kotlin  ACTIVITY 跳转
                 */
//                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
//                OR
                startActivity(Intent(this@SplashActivity, MainActivity().javaClass))
            }
        })
        timer.start()
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
}
