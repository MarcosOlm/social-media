import { useAuth } from '@/stores/authStore'
import axios from 'axios'

export const api = axios.create({
    baseURL: "http://localhost:8080",
})

api.interceptors.request.use((config) => {
    const token = useAuth.getState().token
    if (token) {
        config.headers.Authorization = `Bearer ${token}`
    }
    return config
})

api.interceptors.response.use((resolve) => resolve, (error) => {
    if (error.response.status === 403) {
        window.location.href = "/sign-in";
    }
})