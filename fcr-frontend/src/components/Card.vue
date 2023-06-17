<template>
  <div class="card rounded-5 shadow pb-2" style="display: flex; flex-flow: column wrap; align-items: flex-start;">
    <div class="card-header bg-primary text-white">
      {{ card.title }}
    </div>
    <div style="display: flex; flex-flow: row wrap">
      <div class="pe-3 tag-list" v-for="concept in card.tags.concept">
        <span class="tag-concept"> {{concept}} </span>
      </div>
      <div class="pe-3 tag-list" v-for="technical in card.tags.technical">
        <span class="tag-technical"> {{technical}} </span>
      </div>
      <div class="pe-3 tag-list" v-for="warning in card.tags.warning">
        <span class="tag-warning"> {{warning}} </span>
      </div>
    </div>
    <Button class="details-button" style="border: none;" @click="onClick">View Details</Button>
    <template>
      <Dialog v-model:visible="visible" modal header="Courses" :style="{ width: '50vw' }">
        <div class="semester-list" v-for="(semester, i) in card.semesters">
          <h6>Semester {{i+1}}</h6>
            <span class="course" v-for="course in semester.courses">{{ course }}</span>
          <br/>
        </div>
      </Dialog>
    </template>
  </div>
</template>

<script setup>
import {ref} from "vue";
import Button from "primevue/button";
import Dialog from "primevue/dialog";

defineProps({
  card: {
    default: null,
    type: Object
  }
})
const visible = ref(false);

const onClick = () => visible.value = true;
</script>

<style scoped>
.card-header {
  border-top-left-radius: 30px !important;
  border-top-right-radius: 30px !important;
  align-self: stretch;
  display: flex;
  flex-flow: column nowrap;
  align-items: center;
}

.card>div{
  margin: 0.4rem;
  padding: 0.5rem;
}

.tag-list{
  display: flex;
  flex-flow: row nowrap;
  padding: 0.2rem;
}

.tag-technical{
  font-size: small;
  background-color: #ffde6a;
  border-radius: 8px;
  padding: 0.2rem;
}
.tag-concept{
  font-size: small;
  background-color: #2993D1;
  border-radius: 8px;
  padding: 0.2rem;
}
.tag-warning{
  font-size: small;
  background-color: rgba(204, 19, 61, 0.99);
  border-radius: 8px;
  padding: 0.2rem;
}
.details-button{
  background-color: #2993D1;
  align-self: stretch;
  display: flex;
  flex-flow: column nowrap;
  align-items: center;
  border-radius: 0 0 30px  30px ;
}
.semester-list {
  display: flex;
  flex-flow: row nowrap;
  align-items: flex-start;
  padding: 0.5rem;
}
.course{
  margin: 0.3rem;
}
</style>