import { Search } from "lucide-react";

function SearchBar() {
  return (
    <div className="bg-white rounded-2xl shadow-2xl p-6 w-full max-w-5xl">

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">

        <input
          type="text"
          placeholder="Destination"
          className="border rounded-xl px-4 py-3 outline-none focus:ring-2 focus:ring-blue-500"
        />

        <input
          type="date"
          className="border rounded-xl px-4 py-3 outline-none focus:ring-2 focus:ring-blue-500"
        />

        <input
          type="date"
          className="border rounded-xl px-4 py-3 outline-none focus:ring-2 focus:ring-blue-500"
        />

        <button
          className="bg-blue-600 hover:bg-blue-700 text-white rounded-xl flex items-center justify-center gap-2 transition duration-300"
        >
          <Search size={20} />
          Search
        </button>

      </div>

    </div>
  );
}

export default SearchBar;