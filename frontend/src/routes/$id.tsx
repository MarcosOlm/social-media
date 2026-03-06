import Header from "@/components/Header";
import Post from "@/components/Post";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { useInsertPost, usePost } from "@/features/posts/postHook";
import type { createpostRequest } from "@/features/posts/postType";
import { createFileRoute, Link } from "@tanstack/react-router";
import { ImagePlus, Send, X } from "lucide-react";
import { useState } from "react";
import { useForm, type SubmitHandler } from "react-hook-form";

export const Route = createFileRoute("/$id")({
  component: RouteComponent,
});

function RouteComponent() {
  const [filePreview, setFilePreview] = useState<File | null>(null);
  const { register, handleSubmit } = useForm<createpostRequest>();
  const createPost = useInsertPost();
  const handleCreatePostSubmit: SubmitHandler<createpostRequest> = (data) => {
    createPost.mutate({ data: data, file: filePreview });
  };

  const { data, isPending, isError } = usePost(Route.useParams().id);

  if (!data) {
    return
  }

  return (
    <>
      <main className="lg:grid lg:grid-cols-[auto_1fr] lg:grid-rows-[auto_auto_minmax(0,1fr)]">
        <Header />
        <section className="lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border lg:col-start-2">
          <Post classname="border-b md:px-14 md:mx-auto text-xl" post={data} />
        </section>
        <section
          className="py-5 border-b md:px-14 md:mx-auto lg:col-start-2 lg:row-start-2
        lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border lg:h-min"
        >
          <form
            onSubmit={handleSubmit(handleCreatePostSubmit)}
            className="flex items-center justify-center gap-3 px-4 md:p-0"
          >
            <div className="w-fit h-fit rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <h1>MA</h1>
            </div>
            <Textarea
              className="border resize-none bg-muted h-min"
              {...register("message")}
            />
            <Label>
              <ImagePlus />
              <Input
                type="file"
                accept="image/*,video/*"
                name="file"
                id="file"
                onChange={(e) => setFilePreview(e.target.files?.[0] ?? null)}
                className="hidden"
              />
            </Label>
            <Button>
              <Send size={18} />
            </Button>
          </form>
          {filePreview && (
            <picture className="w-full flex flex-col items-end justify-center mb-3">
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
        </section>
        <section className="lg:col-start-2 lg:row-start-3 lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
          {data.comments?.map((comment) => (
            <Link
              to="/$id"
              params={{
                id: comment.id,
              }}
              key={comment.id}
            >
              <Post classname="md:px-14 md:mx-auto border-b" post={comment} />
            </Link>
          ))}
        </section>
      </main>
    </>
  );
}
