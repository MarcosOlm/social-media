import { Heart, MessageCircle, Share2 } from "lucide-react"
import { Label } from "./ui/label"
import { useState } from "react"
import type { post, postWithoutComment } from "@/features/posts/postType";

type PostProps = {
    classname?: string,
    post: post | postWithoutComment
}

function Post({ classname, post }: PostProps) {
    const [like, setLike] = useState<boolean>(false);
    const [copy, setCopy] = useState<boolean>(false);
    function textCopy(id: string) {
        navigator.clipboard.writeText(`http://MYPROJECT/${id}`)
        setCopy(true)
    }

    return (
        <article className={`w-full grid grid-cols-[auto_1fr] grid-rows-[1fr_auto_1fr] gap-x-5 gap-y-1 p-3 ${classname}`}>
            <div className="w-fit h-fit col-span-1 row-span-3 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <h1>MA</h1>
            </div>
            <h1 className="col-start-2">marcosolm</h1>
            <p className="col-start-2">{ post.menssage }</p>
            <section className="col-start-2 flex items-center justify-start gap-5 w-fit" onClick={(e) => e.preventDefault()}>
                <Label onClick={() => setLike(!like)} className="py-2 px-0.5">
                    <Heart size={18} className={like ? "fill-rose-600 text-rose-600 animate-click" : "text-black"}/>
                    {post.quantLike}
                </Label>
                <Label className="py-2 px-0.5">
                    <MessageCircle size={18}/>
                    {post.commentCount}
                </Label>
                <Share2 size={18} onClick={() => textCopy("1")} className={copy ? "animate-click" : ""}/>
            </section>
        </article>
    )
}

export default Post