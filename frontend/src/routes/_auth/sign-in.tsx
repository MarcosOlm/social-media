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

export const Route = createFileRoute("/_auth/sign-in")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <div className="w-full">
        <form>
          <FieldSet>
            <FieldLegend className="text-center">
              Bem-vindo de volta!
            </FieldLegend>
            <FieldDescription className="text-center">
              Entre para acessar sua conta
            </FieldDescription>
            <FieldGroup>
              <Field>
                <FieldLabel>Nome de usuário:</FieldLabel>
                <Input placeholder="Digite seu nome de usuário..." />
              </Field>
              <Field>
                <FieldLabel>Senha:</FieldLabel>
                <Input placeholder="*******" />
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
