<template>
  <footer class="d-flex flex-wrap justify-content-between align-items-center pt-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
      <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
        <svg class="bi" width="30" height="24">
          <use xlink:href="#bootstrap"></use>
        </svg>
      </a>
      <span class="mb-3 mb-md-0 text-muted">© 2023 Team 20, Inc</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex me-5">
      <li class="me-5">
        <router-link :to="{name: 'privacy'}" class="text-secondary text-decoration-none">Privacy</router-link>
      </li>
      <li class="me-5">
          <router-link :to="{name: 'terms'}" class="text-secondary text-decoration-none">Terms</router-link>
      </li>
      <li class="me-5">
        <router-link :to="{name: 'about'}" class="text-secondary text-decoration-none">About</router-link>
      </li>
    </ul>
  </footer>
</template>

<script setup>

</script>

<style scoped>

</style>