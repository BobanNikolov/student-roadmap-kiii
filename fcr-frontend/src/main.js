import { createApp } from "vue";
import { createPinia } from "pinia";
import App from "./App.vue";
import router from "./router";

import "@/assets/scss/app.scss";
import "@/assets/css/main.css";
import "@formkit/themes/genesis";
import { plugin, defaultConfig } from '@formkit/vue'

import PrimeVue from "primevue/config";

import auth from "./includes/firebase";

let app;

auth.onAuthStateChanged(() => {
    if (!app) {
        app = createApp(App);

        app.use(createPinia());
        app.use(PrimeVue, {ripple: true});
        app.use(plugin, defaultConfig);
        app.use(router);

        app.mount("#app");
    }
})

