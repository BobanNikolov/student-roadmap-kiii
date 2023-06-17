<template>
  <div id="mid-nav">
    <span />
    <router-link id="nav-link" active-class="active" :to="{name: 'roadmap'}">Roadmap</router-link>
    <router-link id="nav-link" active-class="active" :to="{name: 'catalog'}">Catalog</router-link>
    <router-link id="nav-link" active-class="active" :to="{name: 'courses'}">Courses</router-link>
  </div>
</template>

<script setup>
</script>

<style scoped>
#nav-link {
  color: black;
  font-weight: bold;
  margin: 1vh;
  text-decoration: none
}

#mid-nav {
  margin-left: 33vw;
  display: inline-flex;
  justify-content: center;
  align-items: center;
}
</style>