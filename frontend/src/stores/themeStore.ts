import { create } from "zustand";
import { persist } from "zustand/middleware";

type themeState = {
  theme: "light" | "dark";
  setTheme: (newTheme: "light" | "dark") => void;
};

export const useTheme = create<themeState>()(
  persist(
    (set) => ({
      theme: "light",
      setTheme: (newTheme: "light" | "dark") =>
        set(() => {
          document.documentElement.classList.remove("light", "dark");
          if (newTheme == "light") {
            document.documentElement.classList.add("light");
          } else if (newTheme == "dark") {
            document.documentElement.classList.add("dark");
          }
          return { theme: newTheme };
        }),
    }),
    {
      name: "theme",
      onRehydrateStorage: () => (state) => {
        if (state?.theme === "dark") {
          document.documentElement.classList.add("dark");
        }
      },
    },
  ),
);
