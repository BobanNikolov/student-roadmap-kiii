<template>
  <main>
    <div class="container">
      <div class="row" id="margin-row"></div>
      <div class="row align-items-center">
        <div class="col" v-if="userStore.loggedIn">
          <h1>
            Welcome again
          </h1>
        </div>
        <div class="col" v-else>
          <h1>
            Join The Circle
          </h1>
          <h3>
            Get yourself a better learning experience
          </h3>
          <router-link custom v-slot="{ navigate }" :to="{name: 'register'}">
            <Button @click="navigate" id="button" label="Get started" raised rounded />
          </router-link>
        </div>
        <div class="col">
          <img src="/home.svg" class="img-fluid" alt="Home image">
        </div>
      </div>
      <div class="row" id="margin-row"></div>
    </div>
  </main>
</template>

<script setup>
import Button from "primevue/button";
import { useUserStore } from "@/stores/user";
const userStore = useUserStore();
</script>

<style scoped>
h1 {
  font-weight: bold;
}

h3 {
  margin-top: 2%;
}

#button {
  margin-top: 5%;
  width: 50%;
}

#margin-row {
  height: 20vh;
}
</style>