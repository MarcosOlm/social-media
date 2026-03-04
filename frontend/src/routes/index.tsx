import Post from "@/components/Post";
import { Button } from "@/components/ui/button";
import { Field, FieldGroup, FieldLabel, FieldSet } from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { createFileRoute } from "@tanstack/react-router";
import { Bird, ImagePlus, LogOut } from "lucide-react";

export const Route = createFileRoute("/")({
  component: RouteComponent,
});

function RouteComponent() {
  const posts = Array(10).fill(null)

  return (
    <main className="h-screen">
      <section className="flex items-center justify-between p-5 border-b md:px-14 md:mx-auto">
        <div className="p-2 bg-linear-to-tr from-primary to-primary/75 rounded-md">
          <Bird className="text-white" />
        </div>
        <Button variant={"ghost"} size={"lg"}>
          <LogOut />
          Sair
        </Button>
      </section>
      <section className="border-b md:px-14 md:mx-auto">
        <form className="p-4 md:px-0">
          <FieldSet className="w-full grid grid-cols-[1fr_8fr]">
            <div className="w-fit h-fit rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <h1>MA</h1>
            </div>
            <FieldGroup className="col-start-2 gap-3">
              <Field>
                <Textarea
                  placeholder="O que está acontecendo?"
                  className="resize-none"
                />
              </Field>
              <Field orientation={"horizontal"} className="flex justify-between">
                <FieldLabel htmlFor="file" className="flex-none">
                  <ImagePlus />
                  <Input type="file" id="file" className="hidden" />
                </FieldLabel>
                <Button className="rounded-full">Publicar</Button>
              </Field>
            </FieldGroup>
          </FieldSet>
        </form>
      </section>
      <section className="w-full">
        {posts.map((_, index) => (
          <span key={index}>
            <Post classname="md:px-14 md:mx-auto border-b"/>
          </span>
        ))} 
      </section>
    </main>
  );
}
