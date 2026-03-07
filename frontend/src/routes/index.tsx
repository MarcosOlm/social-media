import Header from "@/components/Header";
import Post from "@/components/Post";
import AllPostSkeleton from "@/components/skeletons/AllPostSkeleton";
import { Button } from "@/components/ui/button";
import { Field, FieldGroup, FieldLabel, FieldSet } from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { useAllPost, useInsertPost } from "@/features/posts/postHook";
import type { createpostRequest } from "@/features/posts/postType";
import { createFileRoute, Link } from "@tanstack/react-router";
import { ImagePlus, Loader2Icon, User, X } from "lucide-react";
import { useEffect, useState } from "react";
import { useForm, type SubmitHandler } from "react-hook-form";
import { useInView } from "react-intersection-observer";

export const Route = createFileRoute("/")({
  component: RouteComponent,
});

function RouteComponent() {
  const [filePreview, setFilePreview] = useState<File | null>(null);
  const { register, handleSubmit, reset } = useForm<createpostRequest>();
  const createPost = useInsertPost();
  const handleCreatePostSubmit: SubmitHandler<createpostRequest> = (
    formData,
  ) => {
    createPost.mutate(
      { data: formData, file: filePreview },
      {
        onSuccess() {
          reset();
          setFilePreview(null);
        },
      },
    );
  };

  const { data, isPending, fetchNextPage, isFetchingNextPage, hasNextPage } =
    useAllPost();
  const { ref, inView } = useInView();

  
  useEffect(() => {
    if (inView) {
      fetchNextPage();
    }
  }, [fetchNextPage, inView]);
  
  if (isPending) return <AllPostSkeleton />
  return (
    <main className="lg:grid lg:grid-cols-[auto_1fr] lg:grid-rows-[auto_1fr]">
      <Header />
      <section className="border-b md:px-14 md:mx-auto lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
        <form
          className="p-4 md:px-0"
          onSubmit={handleSubmit(handleCreatePostSubmit)}
        >
          <FieldSet className="w-full grid grid-cols-[auto_1fr]">
            <div className="w-fit h-fit rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <User /> 
            </div>
            <FieldGroup className="col-start-2 gap-3">
              <Field>
                <Textarea
                  placeholder="O que está acontecendo?"
                  className="resize-none"
                  {...register("message")}
                />
              </Field>
              {filePreview && (
                <picture className="w-full flex flex-col items-end justify-center">
                  <Button
                    variant={"ghost"}
                    onClick={() => setFilePreview(null)}
                    className="m-1.5 rounded-full"
                  >
                    <X />
                  </Button>
                  {filePreview.type.startsWith("image") ? (
                    <img
                      src={URL.createObjectURL(filePreview)}
                      alt="preview"
                      className="w-full rounded"
                    />
                  ) : (
                    <video controls>
                      <source src={URL.createObjectURL(filePreview)} />
                    </video>
                  )}
                </picture>
              )}
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
                    onChange={(e) =>
                      setFilePreview(e.target.files?.[0] ?? null)
                    }
                    className="hidden"
                  />
                </FieldLabel>
                <Button
                  className="rounded-full"
                  disabled={createPost.isPending}
                >
                  Publicar
                </Button>
              </Field>
            </FieldGroup>
          </FieldSet>
        </form>
      </section>
      <section className="w-full lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
        {data?.pages.map((page) =>
          page.content.map((post) => (
            <Link
              to="/$id"
              params={{
                id: post.id,
              }}
              key={post.id}
            >
              <Post classname="md:px-14 md:mx-auto border-b" post={post} />
            </Link>
          )),
        )}
        {/* Fetching Next Intersection*/}
        {hasNextPage && (
          <div ref={ref} className="w-full">
            {" "}
            {isFetchingNextPage && (
              <span className="mx-auto my-10 flex items-center justify-center">
                {" "}
                <Loader2Icon className="animate-spin" size={40} />{" "}
              </span>
            )}{" "}
          </div>
        )}
      </section>
    </main>
  );
}
