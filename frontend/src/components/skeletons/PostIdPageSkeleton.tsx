import { ImagePlus, Send } from "lucide-react"
import Header from "../Header"
import { Label } from "../ui/label"
import { Textarea } from "../ui/textarea"
import PostSkeleton from "./PostSkeleton"
import { Input } from "../ui/input"
import { Button } from "../ui/button"
import { Link } from "@tanstack/react-router"
import { Skeleton } from "../ui/skeleton"


function PostIdSkeletonSkeleton() {
    const list = Array(3).fill(null);
    return (
        <main className="lg:grid lg:grid-cols-[auto_1fr] lg:grid-rows-[auto_auto_minmax(0,1fr)]">
        <Header />
        <section className="lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border lg:col-start-2">
          <PostSkeleton />
        </section>
        <section
          className="py-5 border-b md:px-14 md:mx-auto lg:col-start-2 lg:row-start-2
        lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border lg:h-min"
        >
          <form
            className="flex items-center justify-center gap-3 px-4 md:p-0"
          >
            <div className="w-5 h-5 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <Skeleton className="h-full w-full rounded-full"/>
            </div>
            <Textarea
              className="border resize-none bg-muted h-min grow"
            />
            <Label>
              <ImagePlus />
              <Input
                type="file"
                accept="image/*,video/*"
                name="file"
                id="file"
                className="hidden"
              />
            </Label>
            <Button disabled>
              <Send size={18} />
            </Button>
          </form>
        </section>
        <section className="lg:col-start-2 lg:row-start-3 lg:mx-0 lg:mr-auto lg:w-full lg:max-w-[56.25em] lg:border">
          {list.map((_, index) => (
            <Link
              to="/"
              key={index}
            >
              <PostSkeleton />
            </Link>
          ))}
        </section>
      </main>
    )
}

export default PostIdSkeletonSkeleton