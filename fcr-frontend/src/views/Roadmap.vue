<template>
  <custom-layout :menus="menus" @change-array="updateArray">
    <template #content>
      <div style="height: 700px">
        <VueFlow
            v-model="artificialIntelligenceAndBigData"
        />
      </div>
    </template>
  </custom-layout>
</template>

<script setup>
import CustomLayout from "../../layouts/CustomLayout.vue";
import {VueFlow} from '@vue-flow/core'

import '@vue-flow/core/dist/style.css';
import '@vue-flow/core/dist/theme-default.css';
import {ref} from "vue";


const updateArray = (newValues) => {
  artificialIntelligenceAndBigData.value = newValues;
};
const artificialIntelligenceAndBigData = ref([

  // Nodes
  // An input node, specified by using `type: 'input'`
  {
    id: '1',
    type: 'input',
    label: 'Artificial Intelligence and Big Data',
    position: {x: 420, y: 20},
    style: {'font-weight': 'bold', '--vf-node-color': 'blue', 'background-color': '#E5E5FF'}
  },

  // Default nodes, you can omit `type: 'default'`
  {
    id: '2',
    label: 'I Semester',
    position: {x: 180, y: 140},
    style: {'--vf-node-color': 'green', 'font-weight': 'bold', 'background-color': '#EEFFE5'}
  },

  // An output node, specified by using `type: 'output'`
  {
    id: '3',
    label: 'Business and Management',
    position: {x: 10, y: 260},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '4',
    label: 'Introduction to Computer Science',
    position: {x: 74, y: 360},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '5',
    label: 'Calculus',
    position: {x: 160, y: 440},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '6',
    label: 'Professional Skills',
    position: {x: 274, y: 380},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '7',
    label: 'Structural Programming',
    position: {x: 354, y: 310},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },

  // Edges
  {id: 'e1-2', source: '1', target: '2'},
  {id: 'e2-3', source: '2', target: '3'},
  {id: 'e2-4', source: '2', target: '4'},
  {id: 'e2-5', source: '2', target: '5'},
  {id: 'e2-6', source: '2', target: '6'},
  {id: 'e2-7', source: '2', target: '7'},

  {
    id: '8',
    label: 'II Semester',
    position: {x: 720, y: 140},
    style: {'--vf-node-color': 'green', 'font-weight': 'bold', 'background-color': '#EEFFE5'}
  },

  // An output node, specified by using `type: 'output'`
  {
    id: '9',
    label: 'Computer Architecture and Organization',
    position: {x: 530, y: 350},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '10',
    label: 'Discrete Mathematics',
    position: {x: 604, y: 450},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '11',
    label: 'Object-Oriented Analysis and Design',
    position: {x: 760, y: 480},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '12',
    label: 'Object-Oriented Programming ',
    position: {x: 884, y: 400},
    style: {'--vf-node-color': 'purple', '--vf-box-shadow': '', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },
  {
    id: '13',
    label: 'Calculus 2',
    position: {x: 960, y: 322},
    style: {'--vf-node-color': 'purple', 'background-color': '#FDE5FF', 'font-weight': '500'}
  },

  // Edges
  {id: 'e1-8', source: '1', target: '8'},
  {id: 'e8-9', source: '8', target: '9'},
  {id: 'e8-10', source: '8', target: '10'},
  {id: 'e8-11', source: '8', target: '11'},
  {id: 'e8-12', source: '8', target: '12'},
  {id: 'e8-13', source: '8', target: '13'},

])
const menus = [
  {
    titleMenu: 'Careers',
    icon: 'fa-certificate',
    menus: [
      {
        title: 'Artificial Intelligence and Big Data',
        array:'artificialIntelligenceAndBigData'
      },
      {
        title: 'Computer Science and Cyber Security',
        array: 'computerScienceAndCyberSecurity'
      },
      {
        title: 'Software Engineering and Information Systems',
        array: 'softwareEngineeringAndInformationSystems'
      },
    ]
  },
]

</script>

<style scoped>

</style>