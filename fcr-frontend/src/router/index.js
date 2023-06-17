import { createRouter, createWebHistory } from "vue-router";
import {
  Home, About, Catalog,
  Courses, Roadmap,
  Login, Register,
  Privacy, Terms
} from "@/router/components";
import { useUserStore } from "@/stores/user";

const routes = [
  {
    path: "/",
    alias: "/home",
    name: "home",
    component: Home
  },
  {
    path: "/roadmap",
    name: "roadmap",
    component: Roadmap,
    meta: {
      requiresAuth: true,
    }
  },
  {
    path: "/catalog",
    name: "catalog",
    component: Catalog,
    meta: {
      requiresAuth: true,
    }
  },
  {
    path: "/courses",
    name: "courses",
    component: Courses,
    meta: {
      requiresAuth: true,
    }
  },
  {
    path: "/about",
    name: "about",
    component: About
  },
  {
    path: "/login",
    name: "login",
    component: Login,
    meta: {
      requiresAuth: false,
    }
  },
  {
    path: "/register",
    name: "register",
    component: Register,
    meta: {
      requiresAuth: false,
    }
  },
  {
    path: "/privacy-policy",
    name: "privacy",
    component: Privacy,
    meta: {
      requiresAuth: false,
    }
  },
  {
    path: "/terms-of-service",
    name: "terms",
    component: Terms,
    meta: {
      requiresAuth: false,
    }
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (!to.meta.requiresAuth) {
    next();
    return;
  }

  const userStore = useUserStore();

  if (userStore.loggedIn) {
    next();
  } else {
    next({name: "home"});
  }
});

export default router;
