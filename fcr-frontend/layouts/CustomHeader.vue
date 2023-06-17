<template>
  <div class="card relative z-2">
    <menubar id="menubar">
      <template #start>
        <router-link id="nav-link" :to="{name: 'home'}">
          <img alt="logo" src="/logo.svg" height="40" class="mr-2">
        </router-link>
        <template v-if="loggedIn">
          <MidNavBar/>
        </template>
      </template>
      <template #end v-if="loggedIn">
        <Button id="profile-btn" severity="secondary" text>
          <i id="icon" class="pi pi-user" />
        </Button>
        <Button @click.prevent="userStore.logout"
                id="sign-out-btn" severity="secondary" text >
          <i id="icon" class="pi pi-sign-out" />
        </Button>
      </template>
      <template #end v-else>
        <router-link id="nav-link" :to="{name: 'login'}">
          <Button class="text-black" label="Log in" text />
        </router-link>
        <router-link id="nav-link" :to="{name: 'register'}">
          <Button class="text-black" label="Register" text />
        </router-link>
      </template>
    </menubar>
  </div>
</template>

<script setup>
import { storeToRefs } from "pinia";
import { useUserStore } from "@/stores/user";
import Menubar from "primevue/menubar";
import Button from "primevue/button";
import MidNavBar from "@/components/MidNavBar.vue";

const userStore = useUserStore();
const { loggedIn } = storeToRefs(userStore);
</script>

<style scoped>
#profile-btn {
  margin-right: 1vh;
}

#icon {
  font-size: 1.5rem
}

#nav-link {
  color: black;
  font-weight: bold;
  margin: 1vh;
  text-decoration: none
}
/* Do not remove, we use this */
.active {
  border-bottom: 5px solid #2993D1;
}
</style>