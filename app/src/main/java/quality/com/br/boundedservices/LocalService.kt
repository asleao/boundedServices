package quality.com.br.boundedservices

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class LocalService : Service() {

    private val binder = LocalBinder()

    fun currentTime(): String{
        val df = SimpleDateFormat("HH:mm:ss", Locale.US)
        return df.format(Date())

    }
    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    inner class LocalBinder : Binder() {
        fun service(): LocalService{
            return this@LocalService
        }
    }
}

