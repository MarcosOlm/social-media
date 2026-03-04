import { Button } from "@/components/ui/button";
import { Field, FieldDescription, FieldGroup, FieldLabel, FieldLegend, FieldSet } from "@/components/ui/field";
import { Input } from "@/components/ui/input";
import { createFileRoute, Link } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth/sign-up")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <div className="w-full">
        <form>
          <FieldSet>
            <FieldLegend className="text-center">
              Crie sua conta
            </FieldLegend>
            <FieldDescription className="text-center">
              Junte-se a comunidade
            </FieldDescription>
            <FieldGroup>
              <Field>
                <FieldLabel>Nome de usuário:</FieldLabel>
                <Input placeholder="Digite seu nome de usuário..." />
              </Field>
              <Field>
                <FieldLabel>Email:</FieldLabel>
                <Input placeholder="seu@email.com" />
              </Field>
              <Field>
                <FieldLabel>Senha:</FieldLabel>
                <Input placeholder="*******" />
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
