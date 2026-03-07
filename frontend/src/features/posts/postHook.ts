import { useInfiniteQuery, useMutation, useQuery } from "@tanstack/react-query";
import { getAllPost, getPost, createPost } from "./postService";
import type { createpostRequest } from "./postType";

export function usePost(id: string) {
    return useQuery({
        queryKey: ['post', id],
        queryFn: () => getPost(id),
    })
}

export function useAllPost() {
    return useInfiniteQuery({
        queryKey: ['allPost'],
        queryFn: getAllPost,
        initialPageParam: 0,
        getNextPageParam: (lastPage) => lastPage.last ? null : lastPage.number + 1,
    })
}

export function useInsertPost() {
    return useMutation({
        mutationFn: ({data, file}: {data: createpostRequest, file: File | null}) => createPost(data, file),
    })
}