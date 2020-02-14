package com.example.calcpiandsortarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity(), AsyncTaskCallback {

    var dblPi = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //tvRandomList.movementMethod(new ScrollingMovementMethod())
    }

    fun runThreadRunnable(){
        val thread = Thread(Runnable{
            Log.d("THREAD","Thread Started")
            runOnUiThread { tvPi.text = "Thread Started" }
            for(i in 0..100000){
                dblPi += ((-1).toDouble().pow(i.toDouble()) / ((2 * i) + 1)) * 4
                Log.d("THREAD", "Thread has run $i times")
                runOnUiThread{tvPi.text = "Pi is calculated to be $dblPi"}
            }
            Log.d("THREAD", "Thread Stopped")
            //runOnUiThread { tvPi.text = "Thread Stopped" }
        })
        thread.start()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnFindPi -> {
                runThreadRunnable()
            }
            R.id.btnSortRandom -> {
                val newAsyncTask = AsyncTaskPi(this)
                newAsyncTask.execute()
            }
        }
    }

    override fun onResult(result: String?){
        tvRandomList.text = result?: "No Result"
    }

}
