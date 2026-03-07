import { api } from "@/lib/api"

export const likePost = (id: string): Promise<void> => {
    return api.post("/like/insert", {post: id})
}

export const deleteLike = (id: string): Promise<void> => {
    return api.post("/like/remove", {post: id})
}