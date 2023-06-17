import axios from "@/custom-axios/axios";

const service = {
  login: (credentials) => {
    return axios.post("/login", credentials);
  },
  register: (user) => {
    return axios.post("/register", user);
  },
};

export default service;