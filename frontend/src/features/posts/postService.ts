import { api } from "@/lib/api"
import type { allPost, createpostRequest, post } from "./postType"

export const getPost = async (id: string): Promise<post> => {
    return (await api.get(`/post/${id}`)).data
}

export const getAllPost = async ({pageParam}: {pageParam: number}): Promise<allPost> => {
    return (await api.get(`/post?page=${pageParam}&size=10`)).data
}

export const createPost = async (data: createpostRequest, file: File | null): Promise<post> => {
    const formData = new FormData();
    formData.append("PostRequest", new Blob([JSON.stringify(data)], {
        type: 'application/json'
    }))
    if (file) {
        formData.append("file", file)
    }
    return (await api.post("/post", formData, {
        headers: {
            "Content-Type": "multipart/form-data",
        }
    })).data
}