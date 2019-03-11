package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_firebase_sign_in.*

class FirebaseSignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_sign_in)
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            val intent = Intent(this, TicTacToyOnline::class.java)
            startActivity(intent)
        }
    }

    fun loginEvent(view: View) {
        val userEmail = emailSignup.text.toString()
        val userpassword = passwordSignUp.text.toString()
        auth.signInWithEmailAndPassword(userEmail, userpassword).addOnCompleteListener {
            if (it.isSuccessful) {
                val intent = Intent(this, TicTacToyOnline::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error" + it.exception.toString(), Toast.LENGTH_SHORT).show()

            }
        }

    }

    fun SignUp(view: View) {
        var intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
