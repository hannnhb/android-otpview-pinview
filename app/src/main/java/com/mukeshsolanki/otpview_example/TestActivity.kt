package com.mukeshsolanki.otpview_example

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.mukeshsolanki.OnOtpCompletionListener
import com.mukeshsolanki.OtpView

class TestActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_system_example)


        val otpView = findViewById<OtpView>(R.id.otp_view)
        otpView?.setOtpCompletionListener(object: OnOtpCompletionListener{
            override fun onOtpCompleted(otp: String?) {
                otpView.setItemBackground(null)
                otpView.setItemBackground(ContextCompat.getDrawable(applicationContext, R.drawable.bg_invalid_otp))
            }
        })


        otpView.setItemBackground(ContextCompat.getDrawable(applicationContext, R.drawable.bg_item_unselected_otp))
        otpView?.setOnFocusChangeListener { view, b ->
            if (b) {
                otpView.setItemBackground(ContextCompat.getDrawable(applicationContext, R.drawable.bg_item_filled_otp))
            } else {
                otpView.setItemBackground(ContextCompat.getDrawable(applicationContext, R.drawable.bg_item_unselected_otp))
            }
        }
        val rootLayout = findViewById<ConstraintLayout>(R.id.contentLayout)
        rootLayout.setOnClickListener {
            otpView?.clearFocus()
        }
    }
}