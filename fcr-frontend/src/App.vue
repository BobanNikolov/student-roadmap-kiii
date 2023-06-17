<template>
  <custom-header />
  <router-view v-slot=" { Component } ">
    <transition name="fade" mode="out-in">
      <component :is="Component">
      </component>
    </transition>
  </router-view>
  <custom-footer />
</template>


<script setup>
import CustomHeader from "../layouts/CustomHeader.vue";
import CustomFooter from "../layouts/CustomFooter.vue";
import { useUserStore } from "@/stores/user";
import auth from "@/includes/firebase";

const userStore = useUserStore();

if (auth.currentUser) {
  userStore.loggedIn = true;
  userStore.accessToken =  auth.currentUser.accessToken;
}

</script>
<style>
</style>
