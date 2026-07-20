import { Link } from "react-router-dom";
import { Hotel } from "lucide-react";

function Navbar() {

    return (

        <header className="fixed top-0 left-0 w-full z-50 bg-transparent text-white">

            <div className="max-w-7xl mx-auto flex justify-between items-center px-8 py-5">

                <Link
                    to="/"
                    className="flex items-center gap-2"
                >

                    <Hotel
                        size={35}
                        className="text-blue-600"
                    />

                    <span className="text-3xl font-bold text-white">

                        StayEase

                    </span>

                </Link>

                <nav className="hidden md:flex gap-8 font-medium">

                    <Link className="hover:text-blue-300 transition" to="/">Home</Link>

                    <Link className="hover:text-blue-300 transition" to="/">Hotels</Link>

                    <Link className="hover:text-blue-300 transition" to="/">About</Link>

                    <Link className="hover:text-blue-300 transition" to="/">Contact</Link>

                </nav>

                <div className="flex gap-3">

                    <button
                        className="border px-5 py-2 rounded-lg"
                    >

                        Login

                    </button>

                    <button
                        className="bg-blue-600 text-white px-5 py-2 rounded-lg"
                    >

                        Register

                    </button>

                </div>

            </div>

        </header>

    );

}

export default Navbar;