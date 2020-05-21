package by.akelian.dp.anyPizzaApp.ui.profile

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.akelian.dp.anyPizzaApp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_profile_authification.*
import kotlinx.android.synthetic.main.fragment_profile_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Default).launch {
            withContext(Dispatchers.Main) {
                childFragmentManager.beginTransaction()
                    .replace(R.id.profileFrameLayout, AuthFragment())
                    .commit()
            }

        }

        auth = Firebase.auth
        signUpButton.setOnClickListener(this)
        registerUserButton.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUI(currentUser)

    }

    private fun createAccount(email: String, password: String) {
        if (!validateForm()) {
            return

        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Successfully Registered", Toast.LENGTH_LONG).show()
                    updateUI(null)
                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show()
                }
            }
    }


    private fun validateForm(): Boolean {
        var valid = true

        val email = emailAuthEditTextField.text.toString()
        if (TextUtils.isEmpty(email)) {
            emailAuthEditTextField.error = "Required."
            valid = false
        } else {
            emailAuthEditTextField.error = null
        }

        val password = passwordAuthEditTextField.text.toString()
        if (TextUtils.isEmpty(password)) {
            passwordAuthEditTextField.error = "Required."
            valid = false
        } else {
            passwordAuthEditTextField.error = null
        }

        return valid
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            if (user.isEmailVerified) {
                childFragmentManager.beginTransaction()
                    .replace(R.id.profileFrameLayout, AuthFragment())
                    .commit()
            } else {
                childFragmentManager.beginTransaction()
                    .replace(R.id.profileFrameLayout, AuthFragment())
                    .commit()
            }
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.profileFrameLayout, RegisterFragment())
                .commit()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            signUpButton.id -> childFragmentManager.beginTransaction()
                .replace(R.id.profileFrameLayout, AuthFragment())
                .commit()
            registerUserButton.id -> createAccount(
                emailRegisterEditTextField.text.toString(),
                passwordRegisterEditTextField.text.toString()
            )
        }
    }

    companion object {
        private const val TAG = "EmailPassword"
        private const val RC_MULTI_FACTOR = 9005
    }

}
