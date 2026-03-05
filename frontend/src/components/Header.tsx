import { Bird, LogOut } from "lucide-react";
import { Button } from "./ui/button";

function Header() {
  return (
    <header className="flex items-center justify-between p-5 border-b md:px-14 md:mx-auto 
    lg:col-span-1 lg:row-span-full lg:sticky lg:top-0 lg:w-min lg:h-screen lg:border-r lg:flex-col lg:border-b-0 lg:p-5">
      <div className="p-2 bg-linear-to-tr from-primary to-primary/75 rounded-md lg:w-16 lg:px-4">
        <Bird className="text-white lg:m-auto" />
      </div>
      <Button variant={"ghost"} size={"lg"}>
        <LogOut />
        Sair
      </Button>
    </header>
  );
}

export default Header;
