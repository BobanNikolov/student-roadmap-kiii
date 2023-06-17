<template>
  <h3>Log in to your account</h3>
  <br />
  <FormKit
      type="form"
      submit-label="Login"
      @submit="handleSubmit"
  >
    <FormKit
        name="email"
        label="Email address"
        placeholder="username@students.finki.ukim.mk"
        validation="required|email"
        autocomplete="on"
    />
    <FormKit
        type="password"
        name="password"
        label="Password"
        placeholder="Your password"
        validation="required"
        autocomplete="on"
    />
  </FormKit>
</template>

<script setup>
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";

const router = useRouter();
const userStore = useUserStore();
const handleSubmit = async (values) => {
  try {
    await userStore.login(values);
    redirectHome();
  } catch (error) {
    console.log(error);
  }
};

function redirectHome() {
  setTimeout(() => {
    router.push({name: "home"});
  }, 500);
}
</script>

<style scoped>

</style>