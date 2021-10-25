package models

import kotlinx.android.synthetic.main.activity_payment.*

/*
Data class representing a completed set of payment details
Strings are used for numbers to account for leading zeroes
 */
class PaymentModel {
    var cardholderName : String = ""
    var cardNumber : String = ""
    var month : String = ""
    var year : String = ""
    var cvv : String = ""
}