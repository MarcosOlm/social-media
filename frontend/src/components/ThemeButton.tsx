import { useTheme } from "@/stores/themeStore";
import { Button } from "./ui/button";

function ThemeButton() {
  const { theme, setTheme } = useTheme();

  return (
    <Button
      onClick={() => {
        setTheme(theme === "light" ? "dark" : "light");
      }}
      variant={"ghost"}
      className="p-3"
    >
      {theme === "light" ? "🌙 Escuro" : "🌞 Claro"}
    </Button>
  );
}

export default ThemeButton;
