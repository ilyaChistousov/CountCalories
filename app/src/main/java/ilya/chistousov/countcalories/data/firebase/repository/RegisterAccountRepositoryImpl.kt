package ilya.chistousov.countcalories.data.firebase.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ilya.chistousov.countcalories.domain.repository.RegisterAccountRepository
import javax.inject.Inject

class RegisterAccountRepositoryImpl @Inject constructor() : RegisterAccountRepository {

    private var auth = Firebase.auth

    override suspend fun registerAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }
}