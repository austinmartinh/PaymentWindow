package co.uk.mobilise.paymentwindow.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.uk.mobilise.paymentwindow.R
import kotlinx.android.synthetic.main.activity_payment.*
import main.MainApp
import models.PaymentModel


class PaymentActivity : AppCompatActivity() {
    lateinit var app: MainApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        app = application as MainApp


        payButton.setOnClickListener {
            payButtonClicked()
        }

        cancelButton.setOnClickListener {
            cancelButtonClicked()
        }
    }


    fun retrieveDetails(): PaymentModel? {
        var payment = PaymentModel()

        var cardholderName = cardholdersNameField.text.toString()
        var cardNumber = cardNumberField.text.toString()
        var month = expiryMonthField.text.toString()
        var year = expiryYearField.text.toString()
        var cvv = cvvField.text.toString()

        val numericRegex = "[0-9]+".toRegex()
        val alphabetRegex = "[a-zA-Z]+".toRegex()

        if (cardholderName.isBlank()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            return null
        }
        if (cardNumber.isBlank()) {
            Toast.makeText(this, "Please enter your card number", Toast.LENGTH_SHORT).show()
            return null
        }
        if (cardNumber.length < 16) {
            Toast.makeText(this, "Your card number should be 16 digits long", Toast.LENGTH_LONG)
                .show()
            return null
        }
        if (!cardNumber.matches(numericRegex)) {
            Toast.makeText(
                this,
                "Please ensure your card number contains only numbers",
                Toast.LENGTH_LONG
            ).show()
            return null
        }
        if (month.isBlank()) {
            Toast.makeText(this, "Please enter your expiry date", Toast.LENGTH_SHORT).show()
            return null
        }
        if (!month.matches(numericRegex)) {
            Toast.makeText(
                this,
                "Please ensure your month contains only numbers",
                Toast.LENGTH_LONG
            ).show()
            return null
        }
        if (year.isBlank()||year.length <2) {
            Toast.makeText(this, "Please enter your expiry date", Toast.LENGTH_SHORT).show()
            return null
        }
        if (!year.matches(numericRegex)) {
            Toast.makeText(this, "Please ensure your year contains only numbers", Toast.LENGTH_LONG)
                .show()
            return null
        }
        if (cvv.isBlank()) {
            Toast.makeText(this, "Please enter your CVV", Toast.LENGTH_SHORT).show()
            return null
        }
        if (!cvv.matches(numericRegex)) {
            Toast.makeText(this, "Please ensure your CVV contains only numbers", Toast.LENGTH_LONG)
                .show()
            return null
        }

        return payment
    }

    fun payButtonClicked() {
      var payment = retrieveDetails()
        if(payment != null){
            Toast.makeText(this, "Payment details valid", Toast.LENGTH_SHORT).show()
        }
        
    }

    fun cancelButtonClicked() {
        cardholdersNameField.setText("")
        cardNumberField.setText("")
        expiryMonthField.setText("")
        expiryYearField.setText("")
        cvvField.setText("")
    }
}