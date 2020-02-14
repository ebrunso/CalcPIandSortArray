package com.example.calcpiandsortarray

import android.os.AsyncTask
import android.util.Log
import org.greenrobot.eventbus.EventBus
import kotlin.random.Random

class AsyncTaskPi(val asynchTaskCallback: AsyncTaskCallback) : AsyncTask<String, String, String>() {
//class AsyncTaskPi: AsyncTask<String, String, String>() {

    val randomArray = IntArray(1000)
    var randomArrayString = ""

    //Runs on main thread
    //Set up the task to run
    override fun onPreExecute() {
        super.onPreExecute()
    }

    //Runs on worker thread
    //The task that needs to be run
    override fun doInBackground(vararg params: String?): String {

        for(i in 0..randomArray.size - 1){
            randomArray[i] = (Random.nextInt(0, 1000))
            Log.i("TAG", "$i : \t Value: " + randomArray[i].toString())
        }
        randomArray.sort()
        for(i in 0..randomArray.size - 1) {
            randomArrayString += randomArray[i].toString() + " "
        }
        Log.i("TAG", randomArrayString)
        return randomArrayString
    }

    //Runs on main thread
    //Used to get updates about the task status
    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
    }

    //Runs on main thread
    //Reports the results of the task
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        asynchTaskCallback.onResult(result)
    }

}

interface AsyncTaskCallback {
    fun onResult(result: String?)
}