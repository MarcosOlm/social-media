import { api } from "@/lib/api";
import type { signinRequest, signinResponse, signupRequest } from "./authType";

export const signin = async (data: signinRequest): Promise<signinResponse> => {
    return (await api.post("/auth/sign-in", data)).data
}

export const signup = async (data: signupRequest) => {
    return (await api.post("/auth/sign-up", data)).data
}