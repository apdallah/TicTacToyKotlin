package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

    }

    fun SignUpClick(view: View) {
        val userEmail = emailSignup.text.toString()
        val userPassword = passwordSignUp.text.toString()
        val userName = name.text.toString()
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener {
            if (it.isSuccessful) {
                currentUser = auth.currentUser!!
                val firebaseUpdate = UserProfileChangeRequest.Builder().setDisplayName(userName).build()

                currentUser.updateProfile(firebaseUpdate).addOnCompleteListener {
                    val intent = Intent(this, TicTacToyOnline::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Error" + it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
