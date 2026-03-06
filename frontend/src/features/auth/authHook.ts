import { useMutation } from "@tanstack/react-query";
import { signin, signup } from "./authService";
import type { signinRequest, signupRequest } from "./authType";
import { useAuth } from "@/stores/authStore";
import { useNavigate } from "@tanstack/react-router";

export function useSignin() {
    const navigate = useNavigate();
    return useMutation({
        mutationFn:  (data: signinRequest) => signin(data),
        onSuccess: (data) => {
            useAuth.getState().setToken(data.token)
            navigate({to: '/'})
        }
    })
}

export function useSignup() {
    const navigate = useNavigate();
    return useMutation({
        mutationFn: (data: signupRequest) => signup(data),
        onSuccess: () => {
            navigate({to: '/sign-in'})
        }
    })
}