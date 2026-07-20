import { Link } from "react-router-dom";
import { Hotel } from "lucide-react";

function Navbar() {

    return (

        <header className="sticky top-0 bg-white shadow-md z-50">

            <div className="max-w-7xl mx-auto flex justify-between items-center px-8 py-5">

                <Link
                    to="/"
                    className="flex items-center gap-2"
                >

                    <Hotel
                        size={35}
                        className="text-blue-600"
                    />

                    <span className="text-3xl font-bold text-blue-700">

                        StayEase

                    </span>

                </Link>

                <nav className="hidden md:flex gap-8 font-medium">

                    <Link to="/">Home</Link>

                    <Link to="/">Hotels</Link>

                    <Link to="/">About</Link>

                    <Link to="/">Contact</Link>

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