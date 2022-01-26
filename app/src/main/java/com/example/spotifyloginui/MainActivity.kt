package com.example.spotifyloginui

import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.spotifyloginui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var show: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //supportActionBar?.hide()

        supportActionBar?.setElevation(0F)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(parseColor("#121212")))
        supportActionBar?.setTitle(Html.fromHtml("<font color='#121212'></font>"))

        binding.passwordToggle.setOnClickListener {
            if (show) {
                show = false
                binding.passwordToggle.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                binding.passwordEditText.transformationMethod = PasswordTransformationMethod()

            } else {

                show = true
                binding.passwordToggle.setImageResource(R.drawable.ic_baseline_visibility_24)
                binding.passwordEditText.transformationMethod = null

            }
        }

        binding.loginBtn.setOnClickListener {

            Toast.makeText(applicationContext, "Login Done", Toast.LENGTH_SHORT).show()


        }

        binding.loginWithoutBtn.setOnClickListener {

            Toast.makeText(
                applicationContext,
                "Login without password is clicked",
                Toast.LENGTH_SHORT
            ).show()


        }

        binding.mailEditText.setOnFocusChangeListener(View.OnFocusChangeListener { view, b ->
            if (b) {
                binding.mailEditText.setBackground(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.edit_text_focus
                    )
                )
                binding.passwordEditText.setBackground(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.edit_text_bg
                    )
                )

            }

        })

        binding.passwordEditText.setOnFocusChangeListener(View.OnFocusChangeListener { view, b ->
            if (b) {
                binding.mailEditText.setBackground(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.edit_text_bg
                    )
                )
                binding.passwordEditText.setBackground(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.edit_text_focus
                    )
                )

            }
        })


        binding.passwordEditText.addTextChangedListener(TextWatcher)
        binding.mailEditText.addTextChangedListener(TextWatcher)
    }

    private val TextWatcher=object :TextWatcher
    {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            var emailInput: String
            var passwordInput: String

            emailInput=binding.mailEditText.text.toString().trim()
            passwordInput= binding.passwordEditText.text.toString().trim()

            if(!emailInput.isEmpty() && !passwordInput.isEmpty())
            {
                binding.loginBtn.isEnabled=true
                binding.loginBtn.isClickable=true
                binding.loginBtn.setBackground(ContextCompat.getDrawable(applicationContext,R.drawable.login_enabled))

            }
            else{

                binding.loginBtn.isEnabled=false
                binding.loginBtn.isClickable=false
                binding.loginBtn.setBackground(ContextCompat.getDrawable(applicationContext,R.drawable.login_disabled))


            }

        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }


}



