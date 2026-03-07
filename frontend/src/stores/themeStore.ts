import { create } from "zustand";
import { persist } from "zustand/middleware";

type themeState = {
  theme: "light" | "dark";
  setTheme: (newTheme: "light" | "dark") => void;
};

export const useTheme = create<themeState>()(
  persist(
    (set) => ({
      theme: document.documentElement.classList[0] == "light" ? "light" : "dark",
      setTheme: (newTheme: "light" | "dark") => set(() => {
        if (newTheme == "light") {
            document.documentElement.classList.replace("dark", "light");
        }
        else if (newTheme == "dark") {
            document.documentElement.classList.replace("light", "dark");
        }
        return {theme: newTheme}
      }),
    }),
    { name: "theme" },
  ),
);
