import { ImagePlus } from "lucide-react";
import Header from "../Header";
import { Field, FieldGroup, FieldLabel, FieldSet } from "../ui/field";
import { Textarea } from "../ui/textarea";
import { Input } from "../ui/input";
import { Button } from "../ui/button";
import { Link } from "@tanstack/react-router";
import PostSkeleton from "./PostSkeleton";
import { Skeleton } from "../ui/skeleton";

function AllPostSkeleton() {
  const list = Array(10).fill(null);

  return (
    <main className="lg:grid lg:grid-cols-[auto_1fr] lg:grid-rows-[auto_1fr]">
      <Header />
      <section className="border-b md:px-14 md:mx-auto lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
        <form className="p-4 md:px-0">
          <FieldSet className="w-full grid grid-cols-[auto_1fr]">
            <div className="w-5 h-5 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <Skeleton className="h-full w-full rounded-full"/>
            </div>
            <FieldGroup className="col-start-2 gap-3">
              <Field>
                <Textarea
                  placeholder="O que está acontecendo?"
                  className="resize-none"
                />
              </Field>
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
                    className="hidden"
                    disabled
                  />
                </FieldLabel>
                <Button className="rounded-full" disabled>
                  Publicar
                </Button>
              </Field>
            </FieldGroup>
          </FieldSet>
        </form>
      </section>
      <section className="w-full lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
        {list.map((_, index) => (
          <Link to="/" key={index}>
            <PostSkeleton />
          </Link>
        ))}
      </section>
    </main>
  );
}

export default AllPostSkeleton;
