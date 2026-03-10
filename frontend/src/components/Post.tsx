import { Heart, MessageCircle, Share2 } from "lucide-react";
import { Label } from "./ui/label";
import { useState } from "react";
import type { post, postWithoutComment } from "@/features/posts/postType";
import { usePost } from "@/features/posts/postHook";
import { deleteLike, likePost } from "@/features/likes/likeService";
import { useNavigate } from "@tanstack/react-router";

type PostProps = {
  classname?: string;
  post: post | postWithoutComment | undefined;
  hasButtons?: boolean;
};

function Post({ classname, post, hasButtons = true }: PostProps) {
  if (!post) {
    return null;
  }

  // buttons logic
  const [like, setLike] = useState<boolean>(post.liked);
  const [quantLike, setQuantLike] = useState<number>(post.quantLike);
  const [copy, setCopy] = useState<boolean>(false);
  function textCopy(id: string) {
    navigator.clipboard.writeText(`http://localhost/${id}`);
    setCopy(true);
  }

  // image/video logic
  const filePath = post.filePath?.split(".").pop()?.toLocaleLowerCase();
  const imageTypes = ["png", "jpg", "jpeg", "gif", "webp"];
  const videoTypes = ["mp4", "webm", "ogg"];

  // parent post logic
  const navigate = useNavigate();
  const parentId =
    typeof post.parentId !== "string" && post.parentId != null
      ? post.parentId.id
      : undefined;

  const { data } = usePost(parentId ?? "");

  return (
    <article
      className={`w-full grid grid-cols-[auto_1fr] grid-rows-[1fr_auto_${post.filePath ? "auto_" : ""}
      ${typeof post.parentId != "string" && post.parentId != null ? "auto_" : ""}1fr] gap-x-5 gap-y-1 p-3 ${classname}`}
    >
      <div className="w-fit h-fit col-span-1 row-span-3 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
        <h1> {post.createUser.slice(0, 2).toUpperCase()} </h1>
      </div>
      <h1 className="col-start-2"> {post.createUser} </h1>
      <p className="col-start-2">{post.menssage}</p>
      {post.filePath ? (
        imageTypes.includes(filePath ?? "") ? (
          <img
            src={post.filePath}
            className="w-full max-h-[25em] object-cover object-center rounded-2xl"
          />
        ) : post.filePath && videoTypes.includes(filePath ?? "") ? (
          <video
            controls
            className="w-full max-h-[25em] object-cover object-center rounded-2xl"
          >
            <source src={post.filePath} />
          </video>
        ) : (
          <h1>não foi possível carregar a media</h1>
        )
      ) : null}

      {parentId && data && (
        <section
          onClick={(e) => {
            e.preventDefault();
            navigate({ to: "/$id", params: { id: parentId } });
          }}
        >
          <Post key={data.id} post={data} classname="border rounded-2xl my-3" hasButtons={false} />
        </section>
      )}
      {hasButtons && (
        <section
          className="col-start-2 flex items-center justify-start gap-5 w-fit"
          onClick={(e) => e.preventDefault()}
        >
          <Label
            onClick={() => {
              if (!like) {
                likePost(post.id);
                setQuantLike(quantLike + 1);
              } else {
                deleteLike(post.id);
                setQuantLike(quantLike - 1);
              }
              setLike(!like);
            }}
            className="py-2 px-0.5"
          >
            <Heart
              size={18}
              className={
                like
                  ? "fill-rose-600 text-rose-600 animate-click"
                  : ""
              }
            />
            {quantLike}
          </Label>
          <Label className="py-2 px-0.5">
            <MessageCircle size={18} />
            {post.commentCount}
          </Label>
          <Share2
            size={18}
            onClick={() => textCopy("1")}
            className={copy ? "animate-click" : ""}
          />
        </section>
      )}
    </article>
  );
}

export default Post;
