package ti_20411041.mc.mc5markus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ti_20411041.mc.mc5markus.R
import ti_20411041.mc.mc5markus.databinding.ActivityLoginBinding
import ti_20411041.mc.mc5markus.databinding.ActivityRegisterBinding

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var  auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            //Validasi Email
            if (email.isEmpty()){
                binding.edtEmailLogin.error = "Email Harus Diisi Bang"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            //Validasi Email Tdk Sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtPasswordLogin.error = "Email Tidak Valid Bang"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }

            //Validasi Password
            if (password.isEmpty()){
                binding.edtPasswordLogin.error = "Passwor Harus Diisi Bang"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang Bang$email", Toast.LENGTH_SHORT).show()
                    val  intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }
}