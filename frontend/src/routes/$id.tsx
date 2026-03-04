import Header from "@/components/Header";
import Post from "@/components/Post";
import { Button } from "@/components/ui/button";
import { Textarea } from "@/components/ui/textarea";
import { createFileRoute, Link } from "@tanstack/react-router";
import { Send } from "lucide-react";

export const Route = createFileRoute("/$id")({
  component: RouteComponent,
});

function RouteComponent() {
  const comments = Array(10).fill(null);

  return (
    <>
      <Header />
      <main>
        <section>
          <Post classname="border-b md:px-14 md:mx-auto" />
        </section>  
        <section className="py-5 border-b md:px-14 md:mx-auto">
          <form className="flex items-center justify-center gap-3 px-4 md:p-0">
            <div className="w-fit h-fit rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <h1>MA</h1>
            </div>
            <Textarea className="border resize-none bg-muted h-min" />
            <Button>
              <Send size={18} />
            </Button>
          </form>
        </section>
        <section>
          {comments.map((_, index) => (
            <Link
              to="/$id"
              params={{
                id: String(index),
              }}
              key={index}
            >
              <Post classname="md:px-14 md:mx-auto border-b" />
            </Link>
          ))}
        </section>
      </main>
    </>
  );
}
