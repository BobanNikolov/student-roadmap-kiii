<template>
  <custom-layout :menus="menus">
    <template #content>
      <div class="row gap-2 ms-5 mt-5 mb-5 ms-2 mb-2 ">
        <div class="col-lg-3  col-12 text-body" v-for="card in cards">
          <card :card="card"/>
        </div>
      </div>
    </template>
  </custom-layout>
</template>

<script setup>
import CustomLayout from "../../layouts/CustomLayout.vue";
import Card from "../components/Card.vue"

const cards = [
  {
    title: "Artificial Intelligence and Big Data",
    module: "SIIS",
    semesters: [
      {
        courses: [
          "Business and Management",
          "Introduction to Computer Science",
          "Calculus",
          "Professional Skills",
          "Structural Programming"
        ]
      },
      {
        courses: [
          "Computer Architecture and Organization",
          "Discrete Mathematics",
          "Object-Oriented Analysis and Design",
          "Object-Oriented Programming",
          "Calculus 2",
          "AI/ML"
        ]
      }
    ],
    tags: {
      concept: ["AI/ML", "Data Analysis", "Big Data"],
      technical: ["Statistics", "Databases", "Data Modeling"],
      warning: ["Practical Effort", "Mathematics"]
    },
  },
  {
    title: "Computer Science and Cybersecurity",
    semesters: [
      {
        courses: [
          "Business and Management",
          "Introduction to Computer Science",
          "Calculus",
          "Professional Skills",
          "Structural Programming"
        ]
      },
      {
        courses: [
          "Computer Architecture and Organization",
          "Discrete Mathematics",
          "Object-Oriented Analysis and Design",
          "Object-Oriented Programming",
          "Cybersecurity for Beginners",
          "Computer Components"
        ]
      }
    ],
    tags: {
      concept: ["Networks", "Cyber-security", "Software-Security"],
      technical: ["SDS", "SSL", "Auth"],
      warning: ["Practical Effort", "Theory"]
    },
  },
  {
    title: "Data Science and Business Analytics",
    semesters: [
      {
        courses: [
          "Business and Management",
          "Introduction to Computer Science",
          "Calculus",
          "Professional Skills",
          "Structural Programming"
        ]
      },
      {
        courses: [
          "Computer Architecture and Organization",
          "Discrete Mathematics",
          "Object-Oriented Analysis and Design",
          "Object-Oriented Programming",
          "Statistics (Elective)",
          "Databases (Elective)"
        ]
      }
    ],
    tags: {
      concept: ["AI/ML", "Data Analysis", "Big Data"],
      technical: ["Statistics", "Databases", "Data Modeling"],
      warning: ["Practical Effort", "Mathematics"]
    },
  },
  {
    title: "Software Engineering and Information Systems",
    semesters: [
      {
        courses: [
          "Business and Management",
          "Introduction to Computer Science",
          "Calculus",
          "Professional Skills",
          "Structural Programming"
        ]
      },
      {
        courses: [
          "Computer Architecture and Organization",
          "Discrete Mathematics",
          "Object-Oriented Analysis and Design",
          "Object-Oriented Programming",
          "Cybersecurity for Beginners (Elective)",
          "Data Modeling (Elective)"
        ]
      }
    ],
    tags: {
      concept: ["AI/ML", "Data Analysis", "Big Data"],
      technical: ["Statistics", "Databases", "Data Modeling"],
      warning: ["Practical Effort", "Mathematics"]
    },
  },
];
const menus = [
  {
    titleMenu: 'Summer',
    icon: 'fa-check-circle',
    menus: [
      {
        title: 'Level 1',
      },
      {
        title: 'Level 2',
      },
      {
        title: 'Level 3'
      },
    ]
  },
  {
    titleMenu: 'Winter',
    icon: 'fa-check-circle',
    menus: [
      {
        title: 'Level 1',
      },
      {
        title: 'Level 2',
      },
      {
        title: 'Level 3'
      },
    ]
  },
  {
    titleMenu: 'Select:',
    menus: [
      {
        title: 'Mandatory',
        color: 'bg-green'
      },
      {
        title: 'Optional',
        color: 'bg-purple'
      },

    ]
  }
]

</script>

<style scoped>

</style>