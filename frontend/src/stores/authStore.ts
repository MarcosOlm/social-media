import { create } from 'zustand'

type authState = {
    token: string | null,
    setToken: (token: string) => void,
    removetoken: () => void
}

export const useAuth = create<authState>((set) => ({
    token: null,
    setToken: (token) => set(() => ({token: token})),
    removetoken: () => set(() => ({token: null})),
}))