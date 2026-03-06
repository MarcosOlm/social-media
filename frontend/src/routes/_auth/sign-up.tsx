import { Button } from "@/components/ui/button";
import { Field, FieldDescription, FieldGroup, FieldLabel, FieldLegend, FieldSet } from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { useSignup } from "@/features/auth/authHook";
import type { signupRequest } from "@/features/auth/authType";
import { createFileRoute, Link } from "@tanstack/react-router";
import { useForm, type SubmitHandler } from 'react-hook-form'

export const Route = createFileRoute("/_auth/sign-up")({
  component: RouteComponent,
});

function RouteComponent() {
  const { register, handleSubmit } = useForm<signupRequest>();
  const signup = useSignup();
  const handleSignupSubimt: SubmitHandler<signupRequest> = (data) => {
    signup.mutate(data);
  }

  return (
    <>
      <div className="w-full">
        <form onSubmit={handleSubmit(handleSignupSubimt)}>
          <FieldSet>
            <FieldLegend className="text-center">
              Crie sua conta
            </FieldLegend>
            <FieldDescription className="text-center">
              Junte-se a comunidade
            </FieldDescription>
            <FieldGroup>
              <Field>
                <FieldLabel htmlFor="username">Nome de usuário:</FieldLabel>
                <Input placeholder="Digite seu nome de usuário..." id="username" {...register("username")}/>
              </Field>
              <Field>
                <FieldLabel htmlFor="email">Email:</FieldLabel>
                <Input placeholder="seu@email.com" id="email" {...register("email")}/>
              </Field>
              <Field>
                <FieldLabel htmlFor="password">Senha:</FieldLabel>
                <Input placeholder="*******" id="password" {...register("password")}/>
              </Field>
              <Button type="submit">Cadastrar-se</Button>
              <div className="w-full flex items-center justify-center gap-x-1">
                <p>Já tem conta?</p>
                <Link to="/sign-in" className="text-primary hover:underline">
                  Faça login
                </Link>
              </div>
            </FieldGroup>
          </FieldSet>
        </form>
      </div>
    </>
  );
}
