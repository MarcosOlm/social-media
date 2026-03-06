export type signinRequest = {
    username: string,
    password: string
}

export type signinResponse = {
    token: string
}

export type signupRequest = {
    email: string,
} & signinRequest
