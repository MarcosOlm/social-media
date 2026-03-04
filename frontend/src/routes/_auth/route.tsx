import { Bird } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { createFileRoute, Outlet } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <main className="w-full h-screen flex items-center justify-center">
      <Card className="w-[90%] max-w-[40em] shadow-2xl border-0 bg-transparent sm:border sm:bg-card" >
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
