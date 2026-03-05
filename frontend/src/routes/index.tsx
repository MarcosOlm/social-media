import Header from "@/components/Header";
import Post from "@/components/Post";
import { Button } from "@/components/ui/button";
import { Field, FieldGroup, FieldLabel, FieldSet } from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { createFileRoute, Link } from "@tanstack/react-router";
import { ImagePlus, X } from "lucide-react";
import { useState } from "react";

export const Route = createFileRoute("/")({
  component: RouteComponent,
});

function RouteComponent() {
  const [filePreview, setFilePreview] = useState<File | null>(null);
  const posts = Array(20).fill(null);

  return (
    <>
      <main className="lg:grid lg:grid-cols-[auto_1fr] lg:grid-rows-[auto_1fr]">
        <Header />
        <section className="border-b md:px-14 md:mx-auto lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
          <form className="p-4 md:px-0">
            <FieldSet className="w-full grid grid-cols-[auto_1fr]">
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
                {filePreview && 
                    <picture className="w-full flex flex-col items-end justify-center">
                      <Button variant={"ghost"} onClick={() => setFilePreview(null)} className="m-1.5 rounded-full">
                        <X/>
                      </Button>
                      {filePreview.type.startsWith("image") ?
                      <img src={URL.createObjectURL(filePreview)} alt="preview" className="w-full rounded"/> :
                      <video controls>
                        <source src={URL.createObjectURL(filePreview)}/>
                      </video>  
                    }
                    </picture>
                }
                <Field
                  orientation={"horizontal"}
                  className="flex justify-between"
                >
                  <FieldLabel htmlFor="file" className="flex-none">
                    <ImagePlus />
                    <Input
                      type="file"
                      accept="image/*,video/*"
                      name="file"
                      id="file"
                      onChange={(e) => setFilePreview(e.target.files?.[0] ?? null)}
                      className="hidden"
                    />
                  </FieldLabel>
                  <Button className="rounded-full">Publicar</Button>
                </Field>
              </FieldGroup>
            </FieldSet>
          </form>
        </section>
        <section className="w-full lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
          {posts.map((_, index) => (
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
