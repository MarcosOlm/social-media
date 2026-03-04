import { Bird, LogOut } from "lucide-react"
import { Button } from "./ui/button"

function Header() {
    return(
        <header className="flex items-center justify-between p-5 border-b md:px-14 md:mx-auto">
        <div className="p-2 bg-linear-to-tr from-primary to-primary/75 rounded-md">
          <Bird className="text-white" />
        </div>
        <Button variant={"ghost"} size={"lg"}>
          <LogOut />
          Sair
        </Button>
      </header>
    )
}

export default Header