import { Hotel } from "lucide-react";

function Navbar() {
    return (
        <nav className="bg-white shadow-md sticky top-0 z-50">

            <div className="max-w-7xl mx-auto px-6 py-4 flex justify-between items-center">

                <div className="flex items-center gap-2">

                    <Hotel size={32} className="text-blue-600" />

                    <h1 className="text-2xl font-bold text-blue-700">
                        StayEase
                    </h1>

                </div>

                <div className="hidden md:flex gap-8 font-medium">

                    <a href="/" className="hover:text-blue-600">
                        Home
                    </a>

                    <a href="#">
                        Hotels
                    </a>

                    <a href="#">
                        About
                    </a>

                    <a href="#">
                        Contact
                    </a>

                </div>

                <button className="bg-blue-600 text-white px-5 py-2 rounded-xl hover:bg-blue-700 transition">

                    Login

                </button>

            </div>

        </nav>
    );
}

export default Navbar;