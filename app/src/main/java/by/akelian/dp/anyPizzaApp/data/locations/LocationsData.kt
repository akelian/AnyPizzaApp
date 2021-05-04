package by.akelian.dp.anyPizzaApp.data.locations

import com.google.firebase.firestore.FirebaseFirestore

class LocationsData {
    private fun getDocument(db: FirebaseFirestore, path: String) {
        val docRef = db.collection(path)
        docRef.firestore.firestoreSettings
    }
}