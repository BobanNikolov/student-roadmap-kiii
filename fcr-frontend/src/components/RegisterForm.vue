<template>
  <FormKit
      type="form"
      id="registration-example"
      :form-class="submitted ? 'hide' : 'show'"
      submit-label="Register"
      @submit="handleSubmit"
      :actions="false"
      #default="{ value }"
  >
    <h3>Sign up to your account</h3>
    <br />
    <FormKit
        type="text"
        name="username"
        label="Username"
        placeholder="Jane Doe"
        validation="required"
        autocomplete="on"
    />
    <FormKit
        type="text"
        name="email"
        label="Email address"
        placeholder="username@students.finki.ukim.mk"
        validation="required|email"
        autocomplete="on"
    />
    <div class="double">
      <FormKit
          type="password"
          name="password"
          label="Password"
          validation="required|length:6|matches:/[^a-zA-Z]/"
          :validation-messages="{
          matches: 'Please include at least one symbol',
        }"
          placeholder="Your password"
          autocomplete="on"
      />
      <FormKit
          type="password"
          name="password_confirm"
          label="Confirm password"
          placeholder="Confirm password"
          validation="required|confirm"
          autocomplete="on"
      />
    </div>

    <FormKit v-if="submitted"
             id="submit-btn"
             type="submit"
             label="Successful"
             :style="successful"
             disabled
    />
    <FormKit v-else
             id="submit-btn"
             type="submit"
             label="Sign up"
    />
  </FormKit>
</template>

<script setup>
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";

const router = useRouter();
const userStore = useUserStore();

const submitted = ref(false);
const successful = reactive({
  backgroundColor: "green !important",
  width: "100% !important"
})
const handleSubmit = async (values) => {
  try {
    await userStore.register(values);
    submitted.value = true;
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
#submit-btn {
  border-radius: 50%;
}
</style>