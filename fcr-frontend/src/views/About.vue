<template>
  <div class="container">
    <div class="row">
      <div class="col mt-5 text-center">
        <h1 class="fw-bold">About us</h1>
      </div>
    </div>
    <Divider />
    <div class="row" v-for="part in paragraph">
      <p>
        {{ part.text }}
      </p>
    </div>
    <Divider />
    <div class="row">
      <div class="col-auto mb-3" v-for="member in team">
        <Card style="width: 15em; height: 28vh;" class="text-center">
          <template #header>
            <Avatar image="https://img.freepik.com/free-vector/businessman-character-avatar-isolated_24877-60111.jpg"
                    class="mt-3" size="xlarge" shape="circle" />
          </template>
          <template #title>{{ member.name }}</template>
          <template #subtitle>
          <span class="fs-5 text-primary fw-bold">
            {{ member.position }}
          </span>
          </template>
        </Card>
      </div>
    </div>
  </div>
</template>

<script setup>
import Divider from "primevue/divider";
import Card from "primevue/card";
import Avatar from "primevue/avatar";

const paragraph = [
  {
    text: "Welcome to Finki Roadmap, your go-to guide for navigating your academic journey! Our mission is to help students\n" +
        "achieve their academic goals by providing a comprehensive platform that streamlines the college experience."
  },
  {
    text: " At Finki Roadmap, we understand that the academic journey can be overwhelming and confusing at times. That's why\n" +
        "we've created a platform that provides students with all the tools and resources they need to succeed, from\n" +
        "personalized course recommendations to comprehensive career path information."
  },
  {
    text: "Our platform is designed to be user-friendly, with an intuitive interface that makes it easy for students to\n" +
        "find the information they need. Whether you're a freshman just starting out or a senior preparing to graduate,\n" +
        "Finki Roadmap has something for everyone."
  },
  {
    text: "But we're more than just a platform – we're a team of passionate educators and developers who are dedicated to\n" +
        "improving the college experience for students everywhere. We're constantly working to improve our platform and\n" +
        "add new features that make the academic journey smoother and more enjoyable.",
  },
  {
    text: "So whether you're looking to explore new career paths, find the right courses to take, or just need some\n" +
        "guidance along the way, Finki Roadmap has you covered. Join us today and start charting your path to success!"
  },
];
const team = [
  {
    image: "",
    name: "Boban Nikolov",
    position: "Team Leader, Backend Developer",
  },
  {
    image: "",
    name: "Mihajlo Rashajkovski",
    position: "Product Architect, Backend Developer",
  },
  {
    image: "",
    name: "Borche Smileski",
    position: "Frontend Developer",
  },
  {
    image: "",
    name: "Stojan Delenikov",
    position: "Frontend Developer",
  },
  {
    image: "",
    name: "Martin Drobarov",
    position: "Frontend Developer",
  },
  {
    image: "",
    name: "Simeon Markoski",
    position: "UI/UX Developer",
  },
  {
    image: "",
    name: "Tiana Dimova",
    position: "Developer",
  },
  {
    image: "",
    name: "Bisera Stojmanovska",
    position: "Developer",
  },
  {
    image: "",
    name: "Jovana Gjurkovska",
    position: "Developer",
  },
  {
    image: "",
    name: "Nadica Turimandzova",
    position: "Developer",
  },
];
</script>

<style>

</style>
