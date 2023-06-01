package ti_20411041.mc.mc5markus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ti_20411041.mc.mc5markus.R
import ti_20411041.mc.mc5markus.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class Register : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.edtEmailRegister.text.toString()
            val password = binding.edtPasswordRegister.text.toString()

            //Validasi Email
            if (email.isEmpty()){
                binding.edtEmailRegister.error = "Email Harus Diisi Bang"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi Email Tdk Sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailRegister.error = "Email Tidak Valid Bang"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi Password
            if (password.isEmpty()){
                binding.edtPasswordRegister.error = "Passwor Harus Diisi Bang"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi panjang Password
            if (password.length < 6){
                binding.edtPasswordRegister.error = "Passwor Minimal 6 Karakter Bang"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)

        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil Bang", Toast.LENGTH_SHORT).show()
                    val  intent = Intent(this,Login::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}