import { Bird } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { createFileRoute, Outlet } from "@tanstack/react-router";
import { useTheme } from "@/stores/themeStore";

export const Route = createFileRoute("/_auth")({
  component: RouteComponent,
});

function RouteComponent() {
  const { theme } = useTheme();


  return (
    <main className={`w-full h-screen flex items-center justify-center bg-card ${theme === "dark" ? "dark" : ""}`}> 
      <Card className="w-[90%] max-w-[40em] shadow-2xl border-0 sm:border" >
        <CardHeader>
          <CardTitle className="flex items-center justify-center gap-2">
            <div className="p-3 bg-linear-to-tr from-primary to-primary/75 rounded-md">
              <Bird className="text-white"/>
            </div>
          </CardTitle>
        </CardHeader>
        <CardContent>
          <Outlet />
        </CardContent>
      </Card>
    </main>
  );
}
