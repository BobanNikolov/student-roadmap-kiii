<template>
  <div class="container">
    <DataTable
        :value="courses"
        paginator :rows="10"
        :rowsPerPageOptions="[5, 10]"
        tableStyle="min-width: 20rem">
      <Column :sortable="true" field="name" header="Name" style="width: 20%"></Column>
      <Column field="paths" header="Paths"></Column>
      <Column :sortable="true" field="semester" header="Semester"></Column>
      <Column field="credits" header="Credits"></Column>
      <Column :sortable="true" field="type" header="Type"></Column>
      <Column header="Description" style="width: 10%">
        <template #body="{ data }">
          <div class="flex align-items-center gap-2">
            <Button label="Click" icon="pi pi-external-link" @click="visible = true"/>
            <Dialog v-model:visible="visible" modal header="Description" :style="{ width: '50vw' }">
              <p>
                {{ data.description }}
              </p>
            </Dialog>
          </div>
        </template>
      </Column>
    </DataTable>
  </div>
</template>

<script setup>
import {ref} from "vue";
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Button from "primevue/button";
import Dialog from "primevue/dialog";

const visible = ref(false);
const courseType = {
  MANDATORY: 'MANDATORY',
  ELECTIVE: 'ELECTIVE'
};

const description = "Introduction to basic data structures and algorithms needed to understand different\n" +
    "technologies (e.g. databases, application development frameworks). Students will be able\n" +
    "to develop algorithms using f data structures such are: lists, trees, graphs, as well as\n" +
    "searching indexes. Student will be able to implement different algorithms' archetypes\n" +
    "which are used in implementation of many software solutions."

let data = [
  {
    name: "Business and management",
    paths: ["SIIS", "PIT"],
    semester: 1,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Introduction to computer science",
    paths: ["SIIS", "PIT"],
    semester: 1,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Calculus",
    paths: ["SIIS"],
    semester: 1,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Professional skills",
    paths: ["SIIS", "PIT", "CS", "CE"],
    semester: 1,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Structural programming",
    paths: ["SIIS", "PIT", "CS", "CE"],
    semester: 1,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Computer Architecture and Organization",
    paths: ["SIIS", "PIT", "CS", "CE"],
    semester: 2,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Discrete Mathematics",
    paths: ["SIIS"],
    semester: 2,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Object Oriented Analysis and Design",
    paths: ["SIIS"],
    semester: 2,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Object oriented programming",
    paths: ["SIIS", "PIT"],
    semester: 2,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Calculus 2",
    paths: ["SIIS", "PIT"],
    semester: 2,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Computer Components",
    paths: ["SIIS"],
    semester: 2,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Cybersecurity for Beginners",
    paths: ["SIIS"],
    semester: 2,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Marketing",
    paths: ["SIIS", "PIT"],
    semester: 2,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Puzzle based learning",
    paths: ["SIIS"],
    semester: 2,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Algorithms and Data Structures",
    paths: ["SIIS", "PIT", "CS", "CE"],
    semester: 3,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Computer Networks and Security",
    paths: ["SIIS", "PIT", "CS", "CE"],
    semester: 3,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Probability and statistics",
    paths: ["SIIS", "CS", "CE"],
    semester: 3,
    credits: 6,
    type: courseType.MANDATORY,
    description
  },
  {
    name: "Advanced programming",
    paths: ["SIIS"],
    semester: 3,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Client side Inernet programming",
    paths: ["SIIS"],
    semester: 3,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "User interfaces design patterns",
    paths: ["SIIS"],
    semester: 3,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "User support",
    paths: ["SIIS"],
    semester: 3,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
  {
    name: "Еngineering mathematics",
    paths: ["SIIS"],
    semester: 3,
    credits: 6,
    type: courseType.ELECTIVE,
    description
  },
];
const courses = data.map(course => ({
  ...course,
  paths: course.paths.filter(path => typeof path === 'string').join(', ')
}));
</script>

<style scoped>

</style>