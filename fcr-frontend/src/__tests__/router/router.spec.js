import router from "@/router";
import App from "@/App.vue";
import { mount } from "@vue/test-utils";

describe("router test", () => {

  it("should be defined", () => {
    expect(router).toBeDefined();
    expect(router.getRoutes()).not.toBeNull();
  });

  test("routing", async () => {
    router.push("/");
    await router.isReady();
    const wrapper = mount(App, {
      global: {
        plugins: [router]
      },
    });
    expect(wrapper.html()).toContain("Join The Cirlce");
    expect(wrapper.html()).toContain("Get yourself a better learning experience");
  });
});