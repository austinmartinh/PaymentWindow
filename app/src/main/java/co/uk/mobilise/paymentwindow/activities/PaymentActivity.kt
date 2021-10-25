package co.uk.mobilise.paymentwindow.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.uk.mobilise.paymentwindow.R
import main.MainApp


class PaymentActivity : AppCompatActivity() {
    lateinit var app: MainApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        app = application as MainApp
    }
}