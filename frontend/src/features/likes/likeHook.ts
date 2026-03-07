import { useMutation } from "@tanstack/react-query";
import { deleteLike, likePost } from "./likeService";

export function useInsertLike() {
    return useMutation({
        mutationFn: (id: string) => likePost(id),
    })
}

export function useRemoveLike() {
    return useMutation({
        mutationFn: (id: string) => deleteLike(id),
    })
}