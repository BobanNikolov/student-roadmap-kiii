import { defineStore } from "pinia";
import { ref } from "vue";

import auth from "@/includes/firebase";
import { signInWithEmailAndPassword,
  createUserWithEmailAndPassword, signOut
} from "firebase/auth";

export const useUserStore = defineStore("user", () => {
  const loggedIn = ref(false);
  const accessToken = ref("");
  const refreshToken = ref ("");

  let credentials = null;

  async function register (values) {
    try {
      credentials = await createUserWithEmailAndPassword(auth, values.email, values.password);
      loggedIn.value = true;
      accessToken.value = await credentials.user.getIdToken();
      refreshToken.value = credentials.user.refreshToken;
    } catch (error) {
      console.log(error);
    }
  }

  async function login (values) {
    try {
      credentials = await signInWithEmailAndPassword(auth, values.email, values.password);
      console.log(credentials);
      loggedIn.value = true;
      accessToken.value = await credentials.user.getIdToken();
      refreshToken.value = credentials.user.refreshToken;
    } catch (error) {
      console.log(error);
    }
  }

  async function logout () {
    try {
      await signOut(auth);
      window.location.reload();
    } catch (error) {
      console.log(error)
    }
  }

  return { loggedIn, accessToken, refreshToken, login, logout, register };
});