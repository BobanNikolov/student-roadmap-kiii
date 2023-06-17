<template>
  <div class="container">
    <div class="row m-5 justify-content: end;">
      <div class="col-6">
        <img id="fikni-logo" src="/logo.svg" class="img-fluid " alt="...">
      </div>
    </div>
    <div class="row">
      <div class="col-6">
        <img src="/girl_icon.svg" class="img-fluid" alt="...">
      </div>
      <div class="col-6">
        <LoginForm />
      </div>
    </div>
  </div>
</template>

<script setup>
import LoginForm from "@/components/LoginForm.vue";
</script>

<style scoped>
#fikni-logo{
  width: 300px;
}
</style>