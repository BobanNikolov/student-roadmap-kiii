const Home = () => import("@/views/Home.vue");
const About = () => import("@/views/About.vue");
const Catalog = () => import("@/views/Catalog.vue");
const Courses = () => import("@/views/Courses.vue");
const Roadmap = () => import("@/views/Roadmap.vue");
const Login = () => import("@/views/Login.vue");
const Register = () => import("@/views/Register.vue");
const ResetPassword = () => import("@/views/ResetPassword.vue");
const Privacy = () => import("@/views/Privacy.vue");
const Terms = () => import("@/views/Terms.vue");

export {
  Home,
  About,
  Catalog,
  Courses,
  Roadmap,
  Login,
  Register,
  ResetPassword,
  Privacy,
  Terms
};