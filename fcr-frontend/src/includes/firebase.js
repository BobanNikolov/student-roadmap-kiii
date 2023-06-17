import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
    apiKey: "AIzaSyD2WQaNpp5hdxz9CHiFtShLcCeXUZZMxiQ",
    authDomain: "student-roadmap.firebaseapp.com",
    projectId: "student-roadmap",
    storageBucket: "student-roadmap.appspot.com",
    messagingSenderId: "82030479682",
    appId: "1:82030479682:web:74048a95dc65cbd761a0db"
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

export default auth;