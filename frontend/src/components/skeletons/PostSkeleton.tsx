import { Heart, MessageCircle, Share2 } from "lucide-react";
import { Label } from "../ui/label";
import { Skeleton } from "../ui/skeleton";

function PostSkeleton() {
  return (
    <article
      className="w-full grid grid-cols-[auto_1fr] grid-rows-[1fr_auto_1fr] gap-x-5 gap-y-1 p-3 border-b md:px-14 md:mx-auto text-xl"
    >
      <div className="w-5 h-5 col-span-1 row-span-3 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
        <Skeleton className="h-full w-full rounded-full" />
      </div>
      <Skeleton className="h-2 w-20 rounded-2xl col-start-2" />
      <Skeleton className="h-5 w-full rounded-2xlcol-start-2" />
      <section className="col-start-2 flex items-center justify-start gap-5 w-fit">
        <Label className="py-2 px-0.5">
          <Heart size={18} className="text-black" />0
        </Label>
        <Label className="py-2 px-0.5">
          <MessageCircle size={18} />0
        </Label>
        <Share2 size={18} />
      </section>
    </article>
  );
}

export default PostSkeleton;
