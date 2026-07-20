import { MapPin, Star } from "lucide-react";
import { motion } from "framer-motion";

function HotelCard({ hotel }) {
  return (
    <motion.div
      whileHover={{ y: -8 }}
      transition={{ duration: 0.3 }}
      className="bg-white rounded-2xl overflow-hidden shadow-lg"
    >
      <img
        src={hotel.image}
        alt={hotel.name}
        className="h-60 w-full object-cover"
      />

      <div className="p-5">

        <div className="flex justify-between items-center">

          <h2 className="text-xl font-bold">

            {hotel.name}

          </h2>

          <div className="flex items-center gap-1 text-yellow-500">

            <Star size={18} fill="currentColor"/>

            <span>{hotel.rating}</span>

          </div>

        </div>

        <div className="flex items-center gap-2 mt-2 text-gray-500">

          <MapPin size={18}/>

          {hotel.city}

        </div>

        <p className="mt-4 text-gray-600">

          {hotel.description}

        </p>

        <div className="flex justify-between items-center mt-6">

          <div>

            <span className="text-3xl font-bold text-blue-600">

              ₹{hotel.price}

            </span>

            <span className="text-gray-500">

              /night

            </span>

          </div>

          <button
            className="bg-blue-600 hover:bg-blue-700 text-white px-5 py-3 rounded-xl transition"
          >
            View
          </button>

        </div>

      </div>

    </motion.div>
  );
}

export default HotelCard;