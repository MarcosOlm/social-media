import { Heart, MessageCircle, Share2 } from "lucide-react"
import { Label } from "./ui/label"

interface PostProps {
    classname?: string,
}

function Post({ classname }: PostProps) {
    return (
        <article className={`w-full grid grid-cols-[1fr_8fr] grid-rows-[1fr_auto_1fr] gap-x-5 gap-y-1 p-4 ${classname}`}>
            <div className="w-fit h-fit col-span-1 row-span-3 rounded-full bg-linear-to-tr from-primary to-primary/70 text-white p-3">
              <h1>MA</h1>
            </div>
            <h1 className="col-start-2">marcosolm</h1>
            <p className="col-start-2">Dica do dia: sempre use TypeScript nos seus projetos. A tipagem vai salvar sua vida! 💡</p>
            <section className="col-start-2 flex items-center justify-start gap-5">
                <Label>
                    <Heart size={18} className="fill-rose-600 text-rose-600"/>
                    11
                </Label>
                <Label>
                    <MessageCircle size={18}/>
                    11
                </Label>
                <Share2 size={18}/>
            </section>
        </article>
    )
}

export default Post