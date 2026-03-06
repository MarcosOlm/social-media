import { createFileRoute, Link } from "@tanstack/react-router";
import {
  Field,
  FieldDescription,
  FieldGroup,
  FieldLabel,
  FieldLegend,
  FieldSet,
} from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { useForm, type SubmitHandler } from "react-hook-form";
import type { signinRequest } from "@/features/auth/authType";
import { useSignin } from "@/features/auth/authHook";

export const Route = createFileRoute("/_auth/sign-in")({
  component: RouteComponent,
});

function RouteComponent() {
  const { register, handleSubmit } = useForm<signinRequest>();
  const signin = useSignin();
  const handleSigninSubmit: SubmitHandler<signinRequest> = (data) => {
    signin.mutate(data);
  }

  return (
    <>
      <div className="w-full">
        <form onSubmit={handleSubmit(handleSigninSubmit)}>
          <FieldSet>
            <FieldLegend className="text-center">
              Bem-vindo de volta!
            </FieldLegend>
            <FieldDescription className="text-center">
              Entre para acessar sua conta
            </FieldDescription>
            <FieldGroup>
              <Field>
                <FieldLabel htmlFor="username">Nome de usuário:</FieldLabel>
                <Input placeholder="Digite seu nome de usuário..." id="username" {...register("username")}/>
              </Field>
              <Field>
                <FieldLabel htmlFor="password">Senha:</FieldLabel>
                <Input placeholder="*******" id="password" {...register("password")}/>
              </Field>
              <Button type="submit">Entrar</Button>
              <div className="w-full flex items-center justify-center gap-x-1">
                <p>Não tem conta?</p>
                <Link to="/sign-up" className="text-primary hover:underline">
                  Cadastre-se
                </Link>
              </div>
            </FieldGroup>
          </FieldSet>
        </form>
      </div>
    </>
  );
}
