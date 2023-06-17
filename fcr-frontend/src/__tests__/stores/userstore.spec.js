import { useUserStore } from "@/stores/user";
import { createPinia, setActivePinia } from "pinia";

describe("userstore test", () => {
  let store;

  beforeEach(() => {
    setActivePinia(createPinia());
    store = useUserStore();
  });

  it("should be defined", () => {
    expect(store).toBeDefined();
  });

  it("should set correct values", () => {
    expect(store.logged).toBeFalsy();
    store.logged = true;
    expect(store.logged).toBeTruthy();

    expect(store.token).toBeNull();
    store.token = "abc";
    expect(store.token).toBe("abc");
  })
});